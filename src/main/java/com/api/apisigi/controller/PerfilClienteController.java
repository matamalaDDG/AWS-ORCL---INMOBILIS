package com.api.apisigi.controller;

import com.api.apisigi.entity.PerfilCliente;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRCuenta;
import com.api.apisigi.repository.IRPerfilCliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clientes/perfil")
public class PerfilClienteController {

    @Autowired
    @Qualifier("perfilClienteRepo")
    private IRPerfilCliente perfilclienterepo;

    @Autowired
    @Qualifier("cuentaRepo")
    private IRCuenta cuentarepo;

    @GetMapping("/perfilesclientes/listado")
    @ResponseBody
    @JsonFormat
    public List<PerfilCliente> obtenerTodosLosPerfiles() {
        //TODO Agregar LOGS

        List temp_perfiles = new ArrayList();
        perfilclienterepo.findAll().forEach(temp_perfiles::add);
        return temp_perfiles;
        //return regionre.findAll().;
    }

    //#ROUTE METHODS
    //#POST METHOD: INSERCION REGION
    @PostMapping("/usuario/cuenta/{idcuenta}/perfil/nuevoperfil")
    @ResponseBody
    @JsonFormat
    public void createComuna(@PathVariable(value = "idcuenta") String idcuenta,
                             @Valid @RequestBody PerfilCliente perfilCliente) {

        cuentarepo.findById(idcuenta).map((cuenta) -> {
            perfilCliente.setCuenta(cuenta);
            return perfilCliente;
        }).orElseThrow(() -> new ResourceNotFoundExcption("REGIONID " + idcuenta + " not found"));
        perfilclienterepo.delete(perfilCliente);
    }

    @DeleteMapping("/usuario/cuenta/{idcuenta}/perfil/{idperfil}/eliminarperfil")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deletePerfil(@PathVariable(value = "idcuenta") String idcuenta,
                                          @PathVariable(value = "idperfil") String idperfil) {
        if (!cuentarepo.existsById(idcuenta)) {
            throw new ResourceNotFoundExcption("PostId " + idcuenta + " not found");
        }

        return perfilclienterepo.findById(idperfil).map(perfilCliente -> {
            perfilclienterepo.delete(perfilCliente);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + idperfil + " not found"));
    }

    //#UPDATE REGION
    @PutMapping("/usuario/cuenta/{idcuenta}/perfil/{idperfil}/modificarperfil")
    @ResponseBody
    @JsonFormat
    public PerfilCliente updateComuna(@PathVariable(value = "idcuenta") String idcuenta,
                                      @PathVariable(value = "idperfil") String idperfil,
                                      @Valid @RequestBody PerfilCliente perfilClienterequest) {
        if (!cuentarepo.existsById(idcuenta)) {
            throw new ResourceNotFoundExcption("ID " + idcuenta + " not found");
        }

        return perfilclienterepo.findById(idperfil).map(perfilCliente -> {
            perfilCliente.setNombre(perfilClienterequest.getNombre());
            perfilCliente.setApellido(perfilClienterequest.getApellido());
            perfilCliente.setCorreo(perfilClienterequest.getCorreo());
            perfilCliente.setRut(perfilClienterequest.getRut());
            perfilCliente.setTipoCliente(perfilClienterequest.getTipoCliente());
            return perfilclienterepo.save(perfilCliente);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idperfil + "not found"));
    }
}
