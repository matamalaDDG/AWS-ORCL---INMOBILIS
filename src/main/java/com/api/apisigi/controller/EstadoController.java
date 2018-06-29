package com.api.apisigi.controller;

import com.api.apisigi.entity.Estado;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IREstado;
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
@RequestMapping("/api/propiedades/estado")
public class EstadoController {
    public static final Log logger = LogFactory.getLog(EstacionamientoController.class);


    @Autowired
    @Qualifier("estadoRepo")
    private IREstado estadorepo;

    //#GET METHOD
    @GetMapping("/estados")
    @ResponseBody
    @JsonFormat
    public List<Estado> getAllEstado() {
        try {
            logger.info("[Listando Estado : ROUTE: /Documento .... Method: getAllEstado]");
            logger.info("[Estado Listadas : ROUTE: /Documento.... Method: getAllEstado]");
            List temp_Estado = new ArrayList<>();
            estadorepo.findAll().forEach(temp_Estado::add);
            return temp_Estado;
        } catch (Exception ex) {
            logger.error("[Error Estado Listadas : ROUTE: /Documento.... Method: getAllEstado]" + ex.getMessage());
            return null;
        }
    }

    @PostMapping("/estados")
    @ResponseBody
    @JsonFormat
    public void createRegion(@Valid @RequestBody Estado estado) {
        logger.info("[creando Estado ..... : ROUTE:/Estado  .... Method: createDocumento]");
        try {
            logger.info("[creando ..... : ROUTE:/Estado  .... Method: createDocumento]");
            logger.info("[Estado creada : ROUTE:/Estado  .... Method: createDocumento]");
            estadorepo.save(estado);
        } catch (Exception ex) {
            logger.error("[Error creando Estado  : ROUTE: /Estado .... Method: updateDocumento]");
            ex.getMessage();
            return;
        }
    }


    @DeleteMapping("/estado/{estadoId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteEstado(@PathVariable String estadoId) {
        logger.info("[Eliminando estado  : ROUTE: /estado .... Method: deleteEstado]");
        try {
            logger.info("[Eliminando .....  : ROUTE: /estado .... Method: deleteEstado]");
            return estadorepo.findById(estadoId).map(estado -> {
                estadorepo.delete(estado);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + estadoId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error eliminando estacionamiento  : ROUTE: /estado .... Method: deleteEstado]");
            return null;
        }
    }

    @PutMapping("/estado/{estadoId}")
    @ResponseBody
    @JsonFormat
    public void updateEstado(@PathVariable String estadoId,
                             @Valid @RequestBody Estado estadorequest) {
        logger.info("[Actualizando Estado  : ROUTE: /Estado .... Method: updateEstado]");
        try {
            logger.info("[Actualizando ......  : ROUTE: /Estado .... Method: updateEstado]");
            estadorepo.findById(estadoId).map(estado -> {
                estado.setIdEstado(estadorequest.getIdEstado());
                estado.setEstado(estadorequest.getEstado());
                logger.info("[Estado Actualizando  : ROUTE: /Estado .... Method: updateEstado]");
                return estadorepo.save(estado);
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + estadoId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error Actualizando Estado  : ROUTE: /Estado .... Method: updateEstado]");
            return;
        }
    }
}
