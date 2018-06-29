package com.api.apisigi.controller;

import com.api.apisigi.entity.Comuna;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRComuna;
import com.api.apisigi.repository.IRRegion;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ubicacion/comuna")
public class ComunaController {

    //#LOGS
    public static final Log logger = LogFactory.getLog(RegionController.class);

    @Autowired
    @Qualifier("comunaRepo")
    private IRComuna comunarepo;

    @Autowired
    @Qualifier("regionRepo")
    private IRRegion regionrepo;

    //#LISTADO DE COMUNAS
    @GetMapping("/comunas")
    @ResponseBody
    @JsonFormat
    public List<Comuna> getAllComuna() {
        try {
            logger.info("[Buscando Comuna : ROUTE: /comunas .... Method: getAllComuna]");
            logger.info("[Listando Comuna : ROUTE: /comunas .... Method: getAllComuna]");
            logger.info("[Comuna Listadas : ROUTE: /comunas.... Method: getAllComuna]");
            List temp_comuna = new ArrayList<>();
            comunarepo.findAll().forEach(temp_comuna::add);
            //regionre.deleteAll(temp_Regiones);
            return temp_comuna;
            //return regionre.findAll().;

        } catch (Exception ex) {
            logger.error("[Error Comuna Listadas : ROUTE: /comunas.... Method: getAllComuna]" + ex.getMessage());
            return null;
        }
    }

    //#AGREGAR COMUNAS NUEVAS CON RELACION DE REGION
    @PostMapping("/region/{regionId}/comuna")
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

    //# ELIMINAR UNA COMUNA
    @DeleteMapping("/region/{regionId}/comunas/{comunaId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteComment(@PathVariable(value = "regionId") String regionId,
                                           @PathVariable(value = "comunaId") String comunaId) {
        try{
            if (!regionrepo.existsById(regionId)) {
                throw new ResourceNotFoundExcption("PostId " + regionId + " not found");
            }
            return comunarepo.findById(comunaId).map(comuna -> {
                comunarepo.delete(comuna);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + comunaId + " not found"));
        }catch (Exception ex){
            return null;
        }
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
