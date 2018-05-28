package com.api.apisigi.controller;

import com.api.apisigi.entity.DocNotaria;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocNotaria;
import com.api.apisigi.repository.IRDocumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ventas/documentacion/docnotaria")
public class DocNotariaController {
    @Autowired
    @Qualifier("docNotariaRepo")
    private IRDocNotaria docNotariarepo;

    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;

    @GetMapping("/contratos")
    @ResponseBody
    @JsonFormat
    public Iterable<DocNotaria> getAllContrato() {
        return docNotariarepo.findAll();
    }

    @PostMapping("/documento/{documentoId}/NdocNotaria")
    @ResponseBody
    @JsonFormat
    public DocNotaria agregarDocnotaria(@PathVariable(value = "documentoId") String documentoId,
                                    @Valid @RequestBody DocNotaria docNotaria) {
        return docNotariarepo.save(
                documentorepo.findById(documentoId).map(documento -> {
                    docNotaria.setDocumento(documento);
                    return docNotaria;
                }).orElseThrow(() ->
                        new ResourceNotFoundExcption("REGIONID " + documentoId + " not found")
                )
        );
    }

    @PutMapping("/documento/{documentoId}/udocNotaria/{docnotariaid}")
    @ResponseBody
    @JsonFormat
    public DocNotaria updateDocNotaria(@PathVariable(value = "documentoId") String documentoId,
                                   @PathVariable(value = "docnotariaid") String docnotariaid,
                                   @Valid @RequestBody DocNotaria docNotariarequest) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }

        return docNotariarepo.findById(documentoId).map(contrato -> {
            contrato.setIdDocNotaria(docNotariarequest.getIdDocNotaria());
            contrato.setDescripcion(docNotariarequest.getDescripcion());
            contrato.setNomNotario(docNotariarequest.getNomNotario());
            return docNotariarepo.save(contrato);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + docnotariaid + "not found"));
    }

    @DeleteMapping("/documento/{documentoId}/dDocnotaria/{docnotariaid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteContrato(@PathVariable(value = "documentoId") String documentoId,
                                            @PathVariable(value = "docnotariaid") String docnotariaid) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("PostId " + documentoId + " not found");
        }

        return docNotariarepo.findById(docnotariaid).map(docNotaria -> {
            docNotariarepo.delete(docNotaria);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + docnotariaid + " not found"));
    }
}

