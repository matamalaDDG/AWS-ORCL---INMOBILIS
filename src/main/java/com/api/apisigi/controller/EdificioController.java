package com.api.apisigi.controller;

import com.api.apisigi.entity.Edificio;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IREdificio;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/tipo/edificio")
public class EdificioController {
    public static final Log logger = LogFactory.getLog(EdificioController.class);

    @Autowired
    @Qualifier("edificioRepo")
    private IREdificio edificiorepo;

    //#LISTAR TODOS: GETMAPPING
    @GetMapping("/edificios")
    @ResponseBody
    @JsonFormat
    public List<Edificio> getEdificios() {
        logger.info("[Buscando Edificio : ROUTE: /Edificio .... Method: getEdificios]");
        try {
            logger.info("[Listando Edificio : ROUTE: /Edificio .... Method: getEdificios]");
            logger.info("[Edificio Listadas : ROUTE: /Edificio.... Method: getEdificios]");
            List temp_Documento = new ArrayList<>();
            edificiorepo.findAll().forEach(temp_Documento::add);
            return temp_Documento;
        } catch (Exception ex) {
            logger.error("[Error Edificio Listadas : ROUTE: /Edificio.... Method: getEdificios]" + ex.getMessage());
            return null;
        }
    }


    //#AGREGAR: POSTMAPPIG
    @PostMapping("/edificio")
    @ResponseBody
    @JsonFormat
    public void createEdificio(@Valid @RequestBody Edificio edificio) {
        logger.info("[Creando Edificio  : ROUTE: /Edificio .... Method: createDocumento]");
        try {
            logger.info("[creando Edificio..... : ROUTE:: /Edificio .... Method: createDocumento]");
            logger.info("[Edificio creada : ROUTE:/Edificio .... Method: createDocumento]");
            edificiorepo.save(edificio);
        } catch (Exception ex) {
            logger.error("[Error  creando Edificio  ROUTE:/Edificio .... Method: createDocumento]");
            ex.getMessage();
            return;
        }

    }

    //#UPDATE: PUTMAPING
    @PutMapping("/edificio/{edificioId}")
    @ResponseBody
    @JsonFormat
    public void updateEdificio(@PathVariable String edificioId,
                               @Valid @RequestBody Edificio edificiorequest) {
        logger.info("[Modificando Edificio  : ROUTE: /edificio .... Method: updateEdificio]");

        try {
            logger.info("[Actualizando ......  : ROUTE: /edificio .... Method: updateEdificio]");

            edificiorepo.findById(edificioId).map(edificio -> {
                edificio.setIdEdificio(edificiorequest.getIdEdificio());
                edificio.setNombreEdi(edificiorequest.getNombreEdi());
                edificio.setNumeroEdificio(edificiorequest.getNumeroEdificio());
                logger.info("[Edificio Actualizado  : ROUTE: /edificio .... Method: updateEdificio]");
                return edificiorepo.save(edificio);
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + edificioId + " not found"));

        } catch (Exception ex) {
            logger.error("[Error Edificio Actualizado  Error: ROUTE: /edificio .... Method: updateEdificio]");
            ex.getMessage();
            return;
        }

    }

    //#DELETE: DELETEMAPING
    @DeleteMapping("/dedif/{edificioId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String edificioId) {
        logger.info("[Eliminando Edificio : ROUTE: /Edificio .... Method: deleteRegion]");

        try {
            return edificiorepo.findById(edificioId).map(edificio -> {
                logger.info("[Eliminando ......: ROUTE: /Edificio .... Method: deleteRegion]");
                edificiorepo.delete(edificio);
                logger.info("[Eliminando Edificio : ROUTE: /Edificio .... Method: deleteRegion]");
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + edificioId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error Edificio Eliminado  Error: ROUTE: /edificio .... Method: updateEdificio]");
            ex.getMessage();
            return null;
        }
    }
}
