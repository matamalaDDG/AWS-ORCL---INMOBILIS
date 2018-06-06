package com.api.apisigi.controller;

import com.api.apisigi.entity.LiquidacionSueldo;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocumento;
import com.api.apisigi.repository.IRLiquidacionSueldo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/proceso/capacidadeconomica/liquidacionsueldo")
public class LiquidacionSueldoController {

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
        return liquidacionsueldorepo.findAll();
    }

    //    POST MAPPING:
    @PostMapping("/documento/{documentoId}/NComuna")
    @ResponseBody
    @JsonFormat
    public LiquidacionSueldo createLiquidacionSuel(@PathVariable(value = "documentoId") String documentoId,
                                                   @Valid @RequestBody LiquidacionSueldo liquidacionSueldo) {
        return liquidacionsueldorepo.save(
                documentorepo.findById(documentoId).map(documento -> {
                    liquidacionSueldo.setDocumento(documento);
                    return liquidacionSueldo;
                }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + documentoId + " not found")));
    }

    //    PUT MAPPING:
    @PutMapping("/documento/{documentoId}/liquidacionSuel/{liquidacionSueldoId}")
    @ResponseBody
    @JsonFormat
    public LiquidacionSueldo updateLiquidacionSuel(@PathVariable(value = "documentoId") String documentoId,
                                                   @PathVariable(value = "liquidacionSueldoId") String liquidacionSueldoId,
                                                   @Valid @RequestBody LiquidacionSueldo liquidacionsueldorequest) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }

        return liquidacionsueldorepo.findById(liquidacionSueldoId).map(liquidacionSueldo -> {
            liquidacionSueldo.setDecripcion(liquidacionsueldorequest.getDecripcion());
            liquidacionSueldo.setIdLiqSuel(liquidacionsueldorequest.getIdLiqSuel());
            return liquidacionsueldorepo.save(liquidacionSueldo);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + liquidacionSueldoId + "not found"));
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

        return liquidacionsueldorepo.findById(liquidacionSueldoId).map(liquidacionSueldo -> {
            liquidacionsueldorepo.delete(liquidacionSueldo);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + liquidacionSueldoId + " not found"));
    }

}
