package com.api.apisigi.controller;

import com.api.apisigi.entity.Precontrato;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocumento;
import com.api.apisigi.repository.IRPrecontrato;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contratos/precontrato")
public class PreContratoController {

    @Autowired
    @Qualifier("precontratoRepo")
    private IRPrecontrato precontratorepo;

    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;

    @GetMapping("/listado/precontratos")
    @ResponseBody
    @JsonFormat
    public Iterable<Precontrato> getAllContrato() {
        return precontratorepo.findAll();
    }

    @PostMapping("/documento/{documentoId}/nprecontrato")
    @ResponseBody
    @JsonFormat
    public Precontrato agregarPreContrato(@PathVariable(value = "documentoId") String documentoId,
                                          @Valid @RequestBody Precontrato docNotaria) {
        return precontratorepo.save(
                documentorepo.findById(documentoId).map(documento -> {
                    docNotaria.setDocumento(documento);
                    return docNotaria;
                }).orElseThrow(() ->
                        new ResourceNotFoundExcption("ID " + documentoId + " not found")
                )
        );
    }

    @PutMapping("/documento/{documentoId}/uprecontrato/{precontratoid}")
    @ResponseBody
    @JsonFormat
    public Precontrato updateDocNotaria(@PathVariable(value = "documentoId") String documentoId,
                                        @PathVariable(value = "precontratoid") String precontratoid,
                                        @Valid @RequestBody Precontrato precontratorequest) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }

        return precontratorepo.findById(documentoId).map(precontrato -> {
            precontrato.setIdPreContrato(precontratorequest.getIdPreContrato());
            precontrato.setDescripcion(precontratorequest.getDescripcion());
            precontrato.setEstado(precontratorequest.getEstado());
            return precontratorepo.save(precontrato);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + precontratoid + "not found"));
    }

    @DeleteMapping("/documento/{documentoId}/dprecontrato/{precontratoid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteContrato(@PathVariable(value = "documentoId") String documentoId,
                                            @PathVariable(value = "docnotariaid") String precontratoid) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("PostId " + documentoId + " not found");
        }

        return precontratorepo.findById(precontratoid).map(precontrato -> {
            precontratorepo.delete(precontrato);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + precontratoid + " not found"));
    }
}
