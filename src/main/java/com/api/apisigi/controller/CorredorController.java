package com.api.apisigi.controller;

import com.api.apisigi.entity.Corredor;
import com.api.apisigi.repository.IRPerfilCliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/propiedades/corredor")
public class CorredorController {

    @Autowired
    @Qualifier("perfilClienteRepo")
    private IRPerfilCliente perfilcliente;

    @Autowired
    @Qualifier
    priva

    @Autowired
    @Qualifier

    //#LISTADO DE COMUNAS POR ID REGION
    @GetMapping("/usuario/)
    @ResponseBody
    @JsonFormat
    public Optional<Corredor> getAllCorredores(@PathVariable(value = "regionId") String idregion) {
        return comunarepo.findById(idregion);
    }

    //#LISTADO DE COMUNAS POR ID COMUNA
    @GetMapping("/{comunaId}/comunas")
    @ResponseBody
    @JsonFormat
    public Optional<Comuna> getComunas(@PathVariable(value = "comunaId") String idcomuna) {
        return comunarepo.findById(idcomuna);
    }

    //#LISTADO DE COMUNAS
    @GetMapping("/comunas")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @JsonFormat
    public List<Comuna> getAll() {
        return comunarepo.findAll();
    }

    //#AGREGAR COMUNAS NUEVAS CON RELACION DE REGION
    @PostMapping("/region/{regionId}/NComuna")
    @ResponseBody
    @JsonFormat
    public void createComuna(@PathVariable(value = "regionId") String regionId,
                             @Valid @RequestBody Comuna comuna) {

        regionrepo.findById(regionId).map((region) -> {
            //TODO Agregar LOGS

            comuna.setRegion(region);

            return comuna;
        }).orElseThrow(() -> new ResourceNotFoundExcption("REGIONID " + regionId + " not found"));
        comunarepo.delete(comuna);
    }


    //# ELIMINAR UNA COMUNA
    @DeleteMapping("/region/{regionId}/comunas/{comunaId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteComment(@PathVariable(value = "regionId") String regionId,
                                           @PathVariable(value = "comunaId") String comunaId) {
        if (!regionrepo.existsById(regionId)) {
            throw new ResourceNotFoundExcption("PostId " + regionId + " not found");
        }

        return comunarepo.findById(comunaId).map(comuna -> {
            comunarepo.delete(comuna);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + comunaId + " not found"));
    }

    //# PUTCONTROLLER
    @PutMapping("/region/{regionId}/comuna/{comunaId}")
    @ResponseBody
    @JsonFormat
    public Comuna updateComuna(@PathVariable(value = "regionId") String regionId,
                               @PathVariable(value = "comunaId") String comunaId,
                               @Valid @RequestBody Comuna comunaRequest) {
        if (!regionrepo.existsById(regionId)) {
            throw new ResourceNotFoundExcption("ID " + regionId + " not found");
        }

        return comunarepo.findById(comunaId).map(comuna -> {
            comuna.setIdComuna(comunaRequest.getIdComuna());
            comuna.setComuna(comunaRequest.getComuna());
            return comunarepo.save(comuna);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + comunaId + "not found"));
    }

}
