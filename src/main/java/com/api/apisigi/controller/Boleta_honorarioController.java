package com.api.apisigi.controller;

import com.api.apisigi.entity.BoletaHonorario;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRBoletaHonorario;
import com.api.apisigi.repository.IRDocumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ventas/economico/boletahonorario")
public class Boleta_honorarioController {

    //#DEPENDECIAS
    @Autowired
    @Qualifier("boletahonorarioRepo")
    private IRBoletaHonorario boletahonorariorepo;
    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;

    //    GET MAPPING:
    @GetMapping("/liquidacionesSueldo")
    @ResponseBody
    @JsonFormat
    public List<BoletaHonorario> getAllBoletaHonorario() {
        return boletahonorariorepo.findAll();
    }

    //    POST MAPPING:
    @PostMapping("/documento/{documentoId}/nboleta")
    @ResponseBody
    @JsonFormat
    public BoletaHonorario creteBoletaHonorario(@PathVariable(value = "documentoId") String documentoId,
                                                @Valid @RequestBody BoletaHonorario boletaHonorario) {
        return boletahonorariorepo.save(
                documentorepo.findById(documentoId).map(documento -> {
                    boletaHonorario.setDocumento(documento);
                    return boletaHonorario;
                }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + documentoId + " not found")));
    }

    //    PUT MAPPING:

    @PutMapping("/documento/{documentoId}/boletahonorario/{boletahonorarioId}")
    @ResponseBody
    @JsonFormat
    public BoletaHonorario updateBoletaHonorario(@PathVariable(value = "documentoId") String documentoId,
                                                 @PathVariable(value = "boletahonorarioId") String boletahonorarioId,
                                                 @Valid @RequestBody BoletaHonorario boletahonorariorequest) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }

        return boletahonorariorepo.findById(boletahonorarioId).map(boletahonorario -> {
            boletahonorario.setIdBoleta(boletahonorariorequest.getIdBoleta());
            boletahonorario.setDescripcion(boletahonorariorequest.getDescripcion());
            return boletahonorariorepo.save(boletahonorario);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + boletahonorarioId + "not found"));
    }

    //    DELETE MAPPING:
    @DeleteMapping("/documento/{documentoId}/boletahonorarior/{boletahonorarioId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteBoletaHonorario(@PathVariable(value = "documentoId") String documentoId,
                                                   @PathVariable(value = "boletahonorarioId") String boletahonorarioId) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("Id" + documentoId + " not found");
        }

        return boletahonorariorepo.findById(boletahonorarioId).map(boletahonorario -> {
            boletahonorariorepo.delete(boletahonorario);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + boletahonorarioId + " not found"));
    }
}
