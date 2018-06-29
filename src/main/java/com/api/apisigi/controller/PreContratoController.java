package com.api.apisigi.controller;

import com.api.apisigi.entity.Precontrato;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocumento;
import com.api.apisigi.repository.IRPrecontrato;
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
@RequestMapping("/api/propiedades/venta/proceso/documento/contrato/tipo/precontrato")
public class PreContratoController {
    public static final Log logger = LogFactory.getLog(PreContratoController.class);

    @Autowired
    @Qualifier("precontratoRepo")
    private IRPrecontrato precontratorepo;

    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;

    @GetMapping("/listado/precontratos")
    @ResponseBody
    @JsonFormat
    public Iterable<Precontrato> getAllPrecontrato() {
        try {
            logger.info("[Buscando Precontrato : ROUTE: /regiones .... Method: getAllRegiones]");
            logger.info("[Listando Precontrato : ROUTE: /regiones .... Method: getAllRegiones]");
            logger.info("[Precontrato Listadas : ROUTE: /regiones.... Method: getAllRegiones]");
            List temp_Precontrato = new ArrayList<>();
            precontratorepo.findAll().forEach(temp_Precontrato::add);
            //regionre.deleteAll(temp_Regiones);
            return temp_Precontrato;
            //return regionre.findAll().;

        } catch (Exception ex) {
            logger.error("[Error Regiones Listadas : ROUTE: /regiones.... Method: getAllRegiones]" + ex.getMessage());
            return null;
        }
    }

    @PostMapping("/documento/{documentoId}/nprecontrato")
    @ResponseBody
    @JsonFormat
    public void agregarPreContrato(@PathVariable(value = "documentoId") String documentoId,
                                   @Valid @RequestBody Precontrato docNotaria) {

        logger.info("[Agregando Precontrato : ROUTE: /Precontrato .... Method: agregarPreContrato]");
        try {
            logger.info("[Se Esta Agregando Precontrato : ROUTE: /Precontrato .... Method: agregarPreContrato]");

            precontratorepo.save(
                    documentorepo.findById(documentoId).map(documento -> {
                        docNotaria.setDocumento(documento);
                        return docNotaria;
                    }).orElseThrow(() ->
                            new ResourceNotFoundExcption("ID " + documentoId + " not found")
                    )
            );
            logger.info("[Precontrato agregado : ROUTE: /Precontrato.... Method: agregarPreContrato]");
        } catch (Exception ex) {
            logger.error("[Error error Precontrato  : ROUTE: /Precontrato.... Method: agregarPreContrato]" + ex.getMessage());
            return;
        }

    }

    @PutMapping("/documento/{documentoId}/uprecontrato/{precontratoid}")
    @ResponseBody
    @JsonFormat
    public void updatePreContrato(@PathVariable(value = "documentoId") String documentoId,
                                  @PathVariable(value = "precontratoid") String precontratoid,
                                  @Valid @RequestBody Precontrato precontratorequest) {
        if (!documentorepo.existsById(documentoId)) {
            logger.error("[Documento id no existe : ROUTE: /Precontrato.... Method: updatePreContrato]");
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }
        logger.info("[Modificando Precontrato : ROUTE: /Precontrato.... Method: updatePreContrato]");

        try {
            logger.info("[Modificando ......: ROUTE: /Precontrato.... Method: updatePreContrato]");
            precontratorepo.findById(documentoId).map(precontrato -> {
                precontrato.setIdPreContrato(precontratorequest.getIdPreContrato());
                precontrato.setDescripcion(precontratorequest.getDescripcion());
                precontrato.setEstado(precontratorequest.getEstado());
                logger.info("[Precontrato Modificado : ROUTE: /Precontrato.... Method: updatePreContrato]");
                return precontratorepo.save(precontrato);
            }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + precontratoid + "not found"));
        } catch (Exception ex) {
            logger.error("[Error Modificando Precontrato : ROUTE: /Precontrato.... Method: updatePreContrato]");
            return;
        }

    }

    @DeleteMapping("/documento/{documentoId}/dprecontrato/{precontratoid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteContrato(@PathVariable(value = "documentoId") String documentoId,
                                            @PathVariable(value = "precontratoid") String precontratoid) {
        if (!documentorepo.existsById(documentoId)) {
            logger.error("[documentoId no encontrado ......: ROUTE: /Precontrato.... Method: updatePreContrato]");
            throw new ResourceNotFoundExcption("documentoId " + documentoId + " not found");
        }
        logger.info("[Eliminando Precontrato......: ROUTE: /Precontrato.... Method: updatePreContrato]");
        try {
            logger.info("[Eliminando ......: ROUTE: /Precontrato.... Method: updatePreContrato]");
            return precontratorepo.findById(precontratoid).map(precontrato -> {
                precontratorepo.delete(precontrato);
                logger.info("[Precontrato Eliminado ......: ROUTE: /Precontrato.... Method: updatePreContrato]");
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("Precontrato " + precontratoid + " not found"));
        } catch (Exception ex) {
            logger.error("[Al eliminar Precontrato ......: ROUTE: /Precontrato.... Method: updatePreContrato]");
            return null;
        }
    }
}
