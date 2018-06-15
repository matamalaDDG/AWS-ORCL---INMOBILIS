package com.api.apisigi.controller;

import com.api.apisigi.entity.Oficina;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IROficina;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController("")
public class OficinaController {

    //TODO
    //Controlador sin realizar por problemas en atributos tabla patente

    @Autowired
    @Qualifier("oficinaRepo")
    private IROficina oficinarepo;

    //#LISTADO DE COMUNAS
    @GetMapping("/comunas")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @JsonFormat
    public List<Oficina> getAll() {
        return oficinarepo.findAll();
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
            comunarepo.save(comuna);
            return comuna;
        }).orElseThrow(() -> new ResourceNotFoundExcption("REGIONID " + regionId + " not found"));
    }
    //    PUT MAPPING:
    //    DELETE MAPPING:

}
