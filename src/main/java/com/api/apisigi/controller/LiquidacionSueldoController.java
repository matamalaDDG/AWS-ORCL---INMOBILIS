package com.api.apisigi.controller;

import com.api.apisigi.entity.LiquidacionSueldo;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocumento;
import com.api.apisigi.repository.IRLiquidacionSueldo;
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
@RequestMapping("/api/propiedades/proceso/capacidadeconomica/liquidacionsueldo")
public class LiquidacionSueldoController {
    public static final Log logger = LogFactory.getLog(LiquidacionSueldoController.class);

    //LiquidacionuSueldoRepo
    @Autowired
    @Qualifier("liquidacionSueldoRepo")
    private IRLiquidacionSueldo liquidacionsueldorepo;
    //DocumentoRepo repo
    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;


    //    GET MAPPING:
    @GetMapping("/liquidacionesSueldo")
    @ResponseBody
    @JsonFormat
    public List<LiquidacionSueldo> getAllLiquidacionSuel() {
        try {
            logger.info("[Listando LiquidacionSueldo : ROUTE: /LiquidacionSueldo .... Method: getAllEstacionamiento]");
            logger.info("[LiquidacionSueldo Listadas : ROUTE: /LiquidacionSueldo.... Method: getAllEstacionamiento]");
            List temp_LiquidacionSueldo= new ArrayList<>();
            liquidacionsueldorepo.findAll().forEach(temp_LiquidacionSueldo::add);
            return temp_LiquidacionSueldo;
        } catch (Exception ex) {
            logger.error("[Error LiquidacionSueldo Listadas : ROUTE: /LiquidacionSueldoLiquidacionSueldo.... Method: getAllEstacionamiento]" + ex.getMessage());
            return null;
        }
    }

    //    POST MAPPING:
    @PostMapping("/documento/{documentoId}/liquidacionSueldo")
    @ResponseBody
    @JsonFormat
    public void createLiquidacionSuel(@PathVariable(value = "documentoId") String documentoId,
                                      @Valid @RequestBody LiquidacionSueldo liquidacionSueldo) {

        logger.info("[creando LiquidacionSueldo  : ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
        try {
            logger.info("[creando ....  : ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
            liquidacionsueldorepo.save(
                    documentorepo.findById(documentoId).map(documento -> {
                        liquidacionSueldo.setDocumento(documento);
                        logger.info("[ LiquidacionSueldo Creada: ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
                        return liquidacionSueldo;
                    }).orElseThrow(() -> new ResourceNotFoundExcption("documentoId " + documentoId + " not found")));
        } catch (Exception ex) {
            logger.info("[ LiquidacionSueldo Creada: ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
            return;
        }
    }

    //    PUT MAPPING:
    @PutMapping("/documento/{documentoId}/liquidacionSuel/{liquidacionSueldoId}")
    @ResponseBody
    @JsonFormat
    public void updateLiquidacionSuel(@PathVariable(value = "documentoId") String documentoId,
                                      @PathVariable(value = "liquidacionSueldoId") String liquidacionSueldoId,
                                      @Valid @RequestBody LiquidacionSueldo liquidacionsueldorequest) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }
        logger.info("[Actualizando LiquidacionSueldo  : ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
        try {
            logger.info("[Actualizando ....  : ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
            liquidacionsueldorepo.findById(liquidacionSueldoId).map(liquidacionSueldo -> {
                liquidacionSueldo.setDecripcion(liquidacionsueldorequest.getDecripcion());
                liquidacionSueldo.setIdLiqSuel(liquidacionsueldorequest.getIdLiqSuel());
                logger.info("[Actualizada liquidacionSueldo : ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
                return liquidacionsueldorepo.save(liquidacionSueldo);
            }).orElseThrow(() -> new ResourceNotFoundExcption("liquidacionSueldoId " + liquidacionSueldoId + "not found"));
        } catch (Exception ex) {
            logger.error("[Error Actualizando LiquidacionSueldo....  : ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
            ex.getMessage();
            return;
        }
    }

    //    DELETE MAPPING:
    @DeleteMapping("/documento/{documentoId}/liquidacionSuel/{liquidacionSueldoId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteLiquidacionSueld(@PathVariable(value = "documentoId") String documentoId,
                                                    @PathVariable(value = "liquidacionSueldoId") String liquidacionSueldoId) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("Id" + documentoId + " not found");
        }
        logger.info("[Eliminando LiquidacionSueldo  : ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
        try {
            logger.info("[Eliminando ....  : ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
            return liquidacionsueldorepo.findById(liquidacionSueldoId).map(liquidacionSueldo -> {
                logger.info("[Eliminado  LiquidacionSueldo : ROUTE: /LiquidacionSueldo .... Method: createLiquidacionSuel]");
                liquidacionsueldorepo.delete(liquidacionSueldo);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("liquidacionSueldoId " + liquidacionSueldoId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error actualizando Estacionamiento  : ROUTE: /Documento .... Method: updatePost]");
            ex.getMessage();
            return null;
        }
    }

}
