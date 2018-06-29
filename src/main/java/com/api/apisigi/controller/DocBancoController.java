package com.api.apisigi.controller;

import com.api.apisigi.entity.DocBanco;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocBanco;
import com.api.apisigi.repository.IRDocumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/propiedades/proceso/ventas/documentacion/documentosbanco")
public class DocBancoController {
    public static final Log logger = LogFactory.getLog(DocBancoController.class);
    @Autowired
    @Qualifier("docbancoRepo")
    private IRDocBanco docbancorepo;

    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;

    @GetMapping("/documentobanco")
    @ResponseBody
    @JsonFormat
    public Iterable<DocBanco> listarConservadores() {
        return docbancorepo.findAll();
    }

    @PostMapping("/documento/{documentoId}/ndocumentobanco")
    @ResponseBody
    @JsonFormat
    public DocBanco agregarDocBanco(@PathVariable(value = "documentoId") String documentoId,
                                    @Valid @RequestBody DocBanco docBanco) {
        if (!documentorepo.existsById(documentoId)) {
            logger.error("[Error documentoId......: ROUTE: /DocNotaria .... Method: updateDocNotaria]");
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }
        return docbancorepo.save(
                documentorepo.findById(documentoId).map(documento -> {
                    docBanco.setDocumento(documento);
                    return docBanco;
                }).orElseThrow(() ->
                        new ResourceNotFoundExcption("ID " + documentoId + " not found")
                )
        );
    }

    @PutMapping("/documento/{documentoId}/udocumentobanco/{documentobancoid}")
    @ResponseBody
    @JsonFormat
    public DocBanco updateDocBanco(@PathVariable(value = "documentoId") String documentoId,
                                   @PathVariable(value = "precontratoid") String documentobancoid,
                                   @Valid @RequestBody DocBanco conservadorrequest) {

        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }

        return docbancorepo.findById(documentoId).map(docBanco -> {
            docBanco.setIdBanco(conservadorrequest.getIdBanco());
            docBanco.setTipoPago(conservadorrequest.getTipoPago());
            docBanco.setMonto(conservadorrequest.getMonto());
            docBanco.setBanco(conservadorrequest.getBanco());
            return docbancorepo.save(docBanco);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + documentobancoid + "not found"));
    }

    @DeleteMapping("documento/{documentoId}/ddocumentobanco/{documentobancoid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteConservador(@PathVariable(value = "documentoId") String documentoId,
                                               @PathVariable(value = "documentobancoid") String documentobancoid) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("PostId " + documentoId + " not found");
        }

        return docbancorepo.findById(documentobancoid).map(docBanco -> {
            docbancorepo.delete(docBanco);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + documentobancoid + " not found"));
    }
}
