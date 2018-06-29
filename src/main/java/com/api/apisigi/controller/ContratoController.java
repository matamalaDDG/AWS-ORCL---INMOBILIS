package com.api.apisigi.controller;

import com.api.apisigi.entity.Contrato;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRContrato;
import com.api.apisigi.repository.IRDocumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/propiedades/venta/proceso/documento/contrato")
public class ContratoController {

    @Autowired
    @Qualifier("contratoRepo")
    private IRContrato contratorepo;

    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;

    @GetMapping("/contratos")
    @ResponseBody
    @JsonFormat
    public Iterable<Contrato> getAllContrato() {
        return contratorepo.findAll();
    }

    @PostMapping("/documento/{documentoId}/Ncontrato")
    @ResponseBody
    @JsonFormat
    public Contrato agregarContrato(@PathVariable(value = "documentoId") String documentoId,
                                    @Valid @RequestBody Contrato contrato) {

        return contratorepo.save(
                documentorepo.findById(documentoId).map(documento -> {
                    contrato.setTbldocumento(documento);
                    return contrato;
                }).orElseThrow(() ->
                        new ResourceNotFoundExcption("REGIONID " + documentoId + " not found")
                )
        );
    }

    @PutMapping("/documento/{documentoId}/ucontrato/{contratoid}")
    @ResponseBody
    @JsonFormat
    public Contrato updateContrato(@PathVariable(value = "documentoId") String documentoId,
                                   @PathVariable(value = "contratoid") String contratoid,
                                   @Valid @RequestBody Contrato contratorequest) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }

        return contratorepo.findById(contratoid).map(contrato -> {
            contrato.setIdContrato(contratorequest.getIdContrato());
            contrato.setDescripcion(contratorequest.getDescripcion());
            contrato.setFechaInico(contratorequest.getFechaInico());
            contrato.setFechaFin(contratorequest.getFechaFin());
            return contratorepo.save(contrato);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + contratoid + "not found"));
    }

    @DeleteMapping("/documento/{documentoId}/dcontrato/{contratoId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteContrato(@PathVariable(value = "documentoId") String documentoId,
                                            @PathVariable(value = "contratoId") String contratoId) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("PostId " + documentoId + " not found");
        }

        return contratorepo.findById(contratoId).map(comuna -> {
            contratorepo.delete(comuna);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + contratoId + " not found"));
    }
}
