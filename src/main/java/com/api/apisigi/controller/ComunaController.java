package com.api.apisigi.controller;

import com.api.apisigi.entity.Comuna;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRComuna;
import com.api.apisigi.repository.IRRegion;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class ComunaController {

    //#LOGS
    public static final Log logger = LogFactory.getLog(RegionController.class);

    @Autowired
    private IRComuna comunarepo;

    @Autowired
    private IRRegion regionrepo;

    //#LISTADO DE COMUNAS POR ID REGION
    @GetMapping("/region/{regionId}/comunas/ListComunas")
    @ResponseBody
    @JsonFormat
    public Page<Comuna> getAllComunasByRegionID(@PathVariable(value = "regionId") String idregion,
                                                Pageable pageable) {
        return comunarepo.findByRegion_IdRegion(idregion, pageable);
    }

    //#LISTADO DE COMUNAS POR ID COMUNA
    @GetMapping("/{comunaId}/comunas")
    @ResponseBody
    @JsonFormat
    public Page<Comuna> getComunas(@PathVariable(value = "comunaId") String idcomuna,
                                   Pageable pageable) {
        return comunarepo.findByIdComuna(idcomuna, pageable);
    }

    //#LISTADO DE COMUNAS
    @GetMapping("/comunas")
    @ResponseBody
    @JsonFormat
    public List<Comuna> getAll() {
        return comunarepo.findAll();
    }

    //#AGREGAR COMUNAS NUEVAS CON RELACION DE REGION
    @PostMapping("/region/{regionId}/NComuna")
    @ResponseBody
    @JsonFormat
    public Comuna createComuna(@PathVariable(value = "regionId") String regionId,
                               @Valid @RequestBody Comuna comuna) {
        return comunarepo.save(
                regionrepo.findById(regionId).map(region -> {
                    comuna.setRegion(region);
                    return comuna;
                }).orElseThrow(() -> new ResourceNotFoundExcption("REGIONID " + regionId + " not found")
                ));
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
    public Comuna updateComuna(@PathVariable (value = "regionId") String regionId,
                                 @PathVariable (value = "comunaId") String comunaId,
                                 @Valid @RequestBody Comuna comunaRequest) {
        if(!regionrepo.existsById(regionId)) {
            throw new ResourceNotFoundExcption("ID " + regionId + " not found");
        }

        return comunarepo.findById(comunaId).map(comuna -> {
            comuna.setIdComuna(comunaRequest.getIdComuna());
            comuna.setComuna(comunaRequest.getComuna());
            return comunarepo.save(comuna);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + comunaId + "not found"));
    }
}
