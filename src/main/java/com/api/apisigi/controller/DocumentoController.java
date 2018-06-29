package com.api.apisigi.controller;

import com.api.apisigi.entity.Documento;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocumento;
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
@RequestMapping("/api/propiedades/ventas/proceso/documentos")
public class DocumentoController {

    public static final Log logger = LogFactory.getLog(DocNotariaController.class);

    //    INYECCION DE DEPENDENCIAS
    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;

    //    GET MAPPING
    @GetMapping("/documentos")
    @ResponseBody
    @JsonFormat
    public List<Documento> getAllDocumento() {
        logger.info("[Buscando Documento : ROUTE: /Documento .... Method: getAllDocumento]");
        try {
            logger.info("[Listando Documento : ROUTE: /Documento .... Method: getAllDocumento]");
            logger.info("[Documento Listadas : ROUTE: /Documento.... Method: getAllDocumento]");
            List temp_Documento = new ArrayList<>();
            documentorepo.findAll().forEach(temp_Documento::add);
            return temp_Documento;
        } catch (Exception ex) {
            logger.error("[Error Documento Listadas : ROUTE: /Documento.... Method: getAllDocumento]" + ex.getMessage());
            return null;
        }
    }


    //    POST MAPPING
    @PostMapping("/documento")
    @ResponseBody
    @JsonFormat
    public void createDocumento(@Valid @RequestBody Documento documento) {
        logger.info("[Creando Documento  : ROUTE: /Documento .... Method: createDocumento]");
        try {
            logger.info("[creando ..... : ROUTE: .... Method: createDocumento]");
            logger.info("[Documento creada : ROUTE: .... Method: createDocumento]");
            documentorepo.save(documento);
        } catch (Exception ex) {
            logger.error("[Error  creando documento  : ROUTE: .... Method: createDocumento]");
            ex.getMessage();
            return;
        }
    }

    //    UPDATE MAPPING
    @PutMapping("/documento/{documentoId}")
    @ResponseBody
    @JsonFormat
    public void updateDocumento(@PathVariable String documentoId,
                                @Valid @RequestBody Documento documentorequest) {
        logger.info("[actualizando Documento  : ROUTE: /Documento .... Method: updateDocumento]");

        try {
            logger.info("[actualizando ....  : ROUTE: /Documento .... Method: updateDocumento]");
            documentorepo.findById(documentoId).map(documento -> {
                documento.setIdDocumento(documentorequest.getIdDocumento());
                documento.setDescripcion(documentorequest.getDescripcion());
                documento.setDocumento(documentorequest.getDocumento());
                logger.info("[Documento actualizado   : ROUTE: /Documento .... Method: updateDocumento]");
                return documentorepo.save(documento);
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + documentoId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error actualizando Documento  : ROUTE: /Documento .... Method: updateDocumento]");
            ex.getMessage();
            return;
        }
    }

    //    DELETE MAPPING
    @DeleteMapping("/documento/{documentoId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteDocumento(@PathVariable String documentoId) {
        logger.info("[Eliminando Documento  : ROUTE: /Documento .... Method: updateDocumento]");
        try {
            logger.info("[Eliminando..... : ROUTE: /Documento .... Method: updateDocumento]");
            return documentorepo.findById(documentoId).map(documento -> {
                documentorepo.delete(documento);
                logger.info("[Documento Eliminado  : ROUTE: /Documento .... Method: updateDocumento]");
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("documentoId " + documentoId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error eliminando Documento  : ROUTE: /Documento .... Method: deleteDocumento]");
            return null;
        }
    }

}
