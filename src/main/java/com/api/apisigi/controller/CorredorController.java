package com.api.apisigi.controller;

import com.api.apisigi.entity.Corredor;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRCorredor;
import com.api.apisigi.repository.IRPerfilCliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propiedades/corredor")
public class CorredorController {

    @Autowired
    @Qualifier("corredorRepo")
    private IRCorredor corredorrepo;

    @Autowired
    @Qualifier("perfilClienteRepo")
    private IRPerfilCliente perfilcliente;

    //#LISTADO DE COMUNAS
    @GetMapping("/usuario/cuenta/tipousuarios/corredores")
    @ResponseBody
    @ResponseStatus
    @JsonFormat
    public List<Corredor> getAll() {
        return corredorrepo.findAll();
    }

    //#AGREGAR COMUNAS NUEVAS CON RELACION DE REGION
    @PostMapping("/usuario/cuenta/perfilcliente/{idperfil}/tipousuarios/corredores/nuevocorredor")
    @ResponseBody
    @JsonFormat
    public void crearCorredor(@PathVariable(value = "idperfil") String idperfil,
                             @Valid @RequestBody Corredor corredor) {

        perfilcliente.findById(idperfil).map((perfilCliente) -> {
            //TODO Agregar LOGS

            corredor.setPerfilcliente(perfilCliente);

            return corredor;
        }).orElseThrow(() -> new ResourceNotFoundExcption("REGIONID " + idperfil + " not found"));
        corredorrepo.delete(corredor);
    }


    //# ELIMINAR UNA COMUNA
    @DeleteMapping("/usuario/cuenta/perfilcliente/{idperfil}/tipousuarios/corredores/{idcorredor}/deletecorredor")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteComment(@PathVariable(value = "idperfil") String idperfil,
                                           @PathVariable(value = "idcorredor") String idcorredor) {
        if (!perfilcliente.existsById(idperfil)) {
            throw new ResourceNotFoundExcption("PostId " + idperfil + " not found");
        }

        return corredorrepo.findById(idcorredor).map(corredor -> {
            corredorrepo.delete(corredor);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + idcorredor + " not found"));
    }

    //# PUTCONTROLLER
    @PutMapping("/usuario/cuenta/perfilcliente/{idperfil}/tipousuarios/corredores/{idcorredor}/actualizarcorredor")
    @ResponseBody
    @JsonFormat
    public Corredor updateCorreodor(@PathVariable(value = "idperfil") String idperfil,
                               @PathVariable(value = "idcorredor") String idcorredor,
                               @Valid @RequestBody Corredor corredorrequest) {
        if (!perfilcliente.existsById(idperfil)) {
            throw new ResourceNotFoundExcption("ID " + idperfil + " not found");
        }

        return corredorrepo.findById(idcorredor).map(corredor -> {
            corredor.setNombreCorredor(corredorrequest.getNombreCorredor());
            corredor.setIdCorredor(corredorrequest.getIdCorredor());
            return corredorrepo.save(corredor);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idcorredor + "not found"));
    }

}
