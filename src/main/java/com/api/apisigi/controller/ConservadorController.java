package com.api.apisigi.controller;


import com.api.apisigi.entity.Conservador;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRConservador;
import com.api.apisigi.repository.IRDocumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ventas/conservador")
public class ConservadorController {

    @Autowired
    @Qualifier("conservadorRepo")
    private IRConservador conservadorrepo;

    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;

    @GetMapping("/conservadores")
    @ResponseBody
    @JsonFormat
    public Iterable<Conservador> listarConservadores() {
        return conservadorrepo.findAll();
    }

    @PostMapping("/documento/{documentoId}/nconservador")
    @ResponseBody
    @JsonFormat
    public Conservador agregarConservador(@PathVariable(value = "documentoId") String documentoId,
                                          @Valid @RequestBody Conservador conservador) {
        return conservadorrepo.save(
                documentorepo.findById(documentoId).map(documento -> {
                    conservador.setDocumento(documento);
                    return conservador;
                }).orElseThrow(() ->
                        new ResourceNotFoundExcption("REGIONID " + documentoId + " not found")
                )
        );
    }

    @PutMapping("/documento/{documentoId}/uconservadores/{conservadorid}")
    @ResponseBody
    @JsonFormat
    public Conservador updateConservador(@PathVariable(value = "documentoId") String documentoId,
                                        @PathVariable(value = "precontratoid") String conservadorid,
                                        @Valid @RequestBody Conservador conservadorrequest) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }

        return conservadorrepo.findById(documentoId).map(conservador -> {
            conservador.setIdDocConservador(conservadorrequest.getIdDocConservador());
            conservador.setNomConservador(conservadorrequest.getNomConservador());
            return conservadorrepo.save(conservador);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + conservadorid + "not found"));
    }

    @DeleteMapping("/documento/{documentoId}/dconservadores/{conservadorid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteConservador(@PathVariable(value = "documentoId") String documentoId,
                                            @PathVariable(value = "conservadorid") String conservadorid) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("PostId " + documentoId + " not found");
        }

        return conservadorrepo.findById(conservadorid).map(conservador -> {
            conservadorrepo.delete(conservador);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + conservadorid + " not found"));
    }

}
