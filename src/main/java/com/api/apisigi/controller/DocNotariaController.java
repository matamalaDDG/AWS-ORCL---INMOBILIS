package com.api.apisigi.controller;

import com.api.apisigi.entity.DocNotaria;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocNotaria;
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
@RequestMapping("/api/propiedades/proceso/ventas/documentacion/docnotaria")
public class DocNotariaController {
    public static final Log logger = LogFactory.getLog(DocNotariaController.class);

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

    @PostMapping("/documento/{documentoId}/docNotaria")
    @ResponseBody
    @JsonFormat
    public void createDocNotaria(@PathVariable(value = "documentoId") String documentoId,
                                 @Valid @RequestBody DocNotaria docNotaria) {
        logger.info("[Creando DocNotaria Region : ROUTE: /DocNotaria .... Method: createDocNotaria]");
        try {
            logger.info("[Creando ......: ROUTE: /DocNotaria .... Method: createDocNotaria]");
            docNotariarepo.save(
                    documentorepo.findById(documentoId).map(documento -> {
                        docNotaria.setDocumento(documento);
                        logger.info("[DocNotaria creado ......: ROUTE: /DocNotaria .... Method: createDocNotaria]");
                        return docNotaria;
                    }).orElseThrow(() ->
                            new ResourceNotFoundExcption("documento:  " + documentoId + " not found")));
        } catch (Exception ex) {
            logger.error("[DocNotaria creado ......: ROUTE: /DocNotaria .... Method: createDocNotaria]");
            return;
        }

    }

    @PutMapping("/documento/{documentoId}/udocNotaria/{docnotariaid}")
    @ResponseBody
    @JsonFormat
    public void updateDocNotaria(@PathVariable(value = "documentoId") String documentoId,
                                 @PathVariable(value = "docnotariaid") String docnotariaid,
                                 @Valid @RequestBody DocNotaria docNotariarequest) {
        if (!documentorepo.existsById(documentoId)) {
            logger.error("[Error documentoId......: ROUTE: /DocNotaria .... Method: updateDocNotaria]");
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }
        logger.info("[Actualizando DocNotaria  ......: ROUTE: /DocNotaria .... Method: updateDocNotaria]");

        try {
            logger.info("[ Actualizando ......: ROUTE: /DocNotaria .... Method: updateDocNotaria]");
            docNotariarepo.findById(documentoId).map(contrato -> {
                contrato.setIdDocNotaria(docNotariarequest.getIdDocNotaria());
                contrato.setDescripcion(docNotariarequest.getDescripcion());
                contrato.setNomNotario(docNotariarequest.getNomNotario());
                logger.info("[ DocNotaria Actualizado   ......: ROUTE: /DocNotaria .... Method: updateDocNotaria]");
                return docNotariarepo.save(contrato);
            }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + docnotariaid + "not found"));
        } catch (Exception ex) {
            logger.error("[Error updateDocNotaria DocNotaria  ......: ROUTE: /DocNotaria .... Method: updateDocNotaria]");
            ex.getMessage();
            return;
        }
    }

    @DeleteMapping("/documento/{documentoId}/dDocnotaria/{docnotariaid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteDocNotaria(@PathVariable(value = "documentoId") String documentoId,
                                              @PathVariable(value = "docnotariaid") String docnotariaid) {
        if (!documentorepo.existsById(documentoId)) {
            logger.error("[Error documentoId DocNotaria  ......: ROUTE: /DocNotaria .... Method: deleteDocNotaria]");
            throw new ResourceNotFoundExcption("PostId " + documentoId + " not found");
        }
        logger.error("[Eliminando  DocNotaria  ......: ROUTE: /DocNotaria .... Method: deleteDocNotaria]");

        try {
            logger.error("[Eliminando... : ROUTE: /DocNotaria .... Method: deleteDocNotaria]");
            return docNotariarepo.findById(docnotariaid).map(docNotaria -> {
                logger.error("[DocNotaria Eliminado   ......: ROUTE: /DocNotaria .... Method: deleteDocNotaria]");
                docNotariarepo.delete(docNotaria);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + docnotariaid + " not found"));
        } catch (Exception ex) {
            logger.error("[Error Eliminando DocNotaria  ......: ROUTE: /DocNotaria .... Method: deleteContrato]");
            ex.getMessage();
            return null;
        }
    }
}

