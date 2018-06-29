package com.api.apisigi.controller;

import com.api.apisigi.entity.Tasacion;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocumento;
import com.api.apisigi.repository.IRTasacion;
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
@RequestMapping("/api/propiedades/ventas/en_Venta/tasacion")
public class TasacionController {
    public static final Log logger = LogFactory.getLog(TasacionController.class);
        @Autowired
        @Qualifier("tasacionRepo")
        private IRTasacion tasacionrepo;

        @Autowired
        @Qualifier("documentoRepo")
        private IRDocumento documentorepo;

        @GetMapping("/tasaciones")
        @ResponseBody
        @JsonFormat
        public Iterable<Tasacion> getAllTasacion()
        {
            try {
                logger.info("[Buscando Tasacion : ROUTE: /Tasacion .... Method: getAllTasacion]");
                logger.info("[Listando Tasacion : ROUTE: /Tasacion .... Method: getAllTasacion]");
                logger.info("[Tasacion Listadas : ROUTE: /Tasacion.... Method: getAllTasacion]");
                List temp_Tasacion = new ArrayList<>();
                tasacionrepo.findAll().forEach(temp_Tasacion::add);
                return temp_Tasacion;
            } catch (Exception ex) {
                logger.error("[Error Listando Tasacion : ROUTE: /Tasacion.... Method: getAllTasacion]" + ex.getMessage());
                return null;
            }
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
