package com.api.apisigi.controller;

import com.api.apisigi.entity.Tasacion;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocumento;
import com.api.apisigi.repository.IRTasacion;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("propiedad/ventas/en_Venta/tasacion")
public class TasacionController {

        @Autowired
        @Qualifier("tasacionRepo")
        private IRTasacion tasacionrepo;

        @Autowired
        @Qualifier("documentoRepo")
        private IRDocumento documentorepo;

        @GetMapping("/listado/tasaciones")
        @ResponseBody
        @JsonFormat
        public Iterable<Tasacion> getAllContrato() {
            return tasacionrepo.findAll();
        }

        @PostMapping("/documento/{documentoId}/ntasacion")
        @ResponseBody
        @JsonFormat
        public Tasacion agregarPreContrato(@PathVariable(value = "documentoId") String documentoId,
                                              @Valid @RequestBody Tasacion tasacion) {
            return tasacionrepo.save(
                    documentorepo.findById(documentoId).map(documento -> {
                        tasacion.setDocumento(documento);
                        return tasacion;
                    }).orElseThrow(() ->
                            new ResourceNotFoundExcption("ID " + documentoId + " not found")
                    )
            );
        }

        @PutMapping("/documento/{documentoId}/utasacion/{tasacionid}")
        @ResponseBody
        @JsonFormat
        public Tasacion updateDocNotaria(@PathVariable(value = "documentoId") String documentoId,
                                            @PathVariable(value = "tasacionid") String precontratoid,
                                            @Valid @RequestBody Tasacion tasacionrequest) {
            if (!documentorepo.existsById(documentoId)) {
                throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
            }

            return tasacionrepo.findById(documentoId).map(tasacion -> {
                tasacion.setIdTasacion(tasacionrequest.getIdTasacion());
                tasacion.setMonto(tasacionrequest.getMonto());
                tasacion.setNomTasador(tasacionrequest.getNomTasador());
                tasacion.setDescripcion(tasacionrequest.getDescripcion());

                return tasacionrepo.save(tasacion);
            }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + precontratoid + "not found"));
        }

        @DeleteMapping("/documento/{documentoId}/dtasacion/{tasacionid}")
        @ResponseBody
        @JsonFormat
        public ResponseEntity<?> deleteContrato(@PathVariable(value = "documentoId") String documentoId,
                                                @PathVariable(value = "tasacionid") String tasacionid) {
            if (!documentorepo.existsById(documentoId)) {
                throw new ResourceNotFoundExcption("PostId " + documentoId + " not found");
            }

            return tasacionrepo.findById(documentoId).map(tasacion -> {
                tasacionrepo.delete(tasacion);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + tasacionid + " not found"));
        }
    }
