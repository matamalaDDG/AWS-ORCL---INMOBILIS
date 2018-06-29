package com.api.apisigi.controller;

import com.api.apisigi.entity.Estacionamiento;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IREstacionamiento;
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
@RequestMapping("/api/propiedades/tipo/estacionamiento")
public class EstacionamientoController {
    public static final Log logger = LogFactory.getLog(EstacionamientoController.class);

    @Autowired
    @Qualifier("estacionamientoRepo")
    private IREstacionamiento estacionamientorepo;

    @GetMapping("/estacionamientos")
    @ResponseBody
    @JsonFormat
    public List<Estacionamiento> getAllEstacionamiento() {
        try {
            logger.info("[Listando Estacionamiento : ROUTE: /Documento .... Method: getAllEstacionamiento]");
            logger.info("[Estacionamiento Listadas : ROUTE: /Documento.... Method: getAllEstacionamiento]");
            List temp_Estacionamiento = new ArrayList<>();
            estacionamientorepo.findAll().forEach(temp_Estacionamiento::add);
            return temp_Estacionamiento;
        } catch (Exception ex) {
            logger.error("[Error Estacionamiento Listadas : ROUTE: /Documento.... Method: getAllEstacionamiento]" + ex.getMessage());
            return null;
        }
    }

    @PostMapping("/estacionamiento")
    @ResponseBody
    @JsonFormat
    public void createEstacionamiento(@Valid @RequestBody Estacionamiento estacionamiento) {
        logger.info("[creando Estacionamiento ..... : ROUTE: .... Method: createDocumento]");
        try {
            logger.info("[creando ..... : ROUTE: .... Method: createDocumento]");
            logger.info("[Estacionamiento creada : ROUTE: .... Method: createDocumento]");
            estacionamientorepo.save(estacionamiento);
        } catch (Exception ex) {
            logger.error("[Error creando Estacionamiento  : ROUTE: /Documento .... Method: updateDocumento]");
            ex.getMessage();
            return;
        }
    }

    @DeleteMapping("/estacionamiento/{estacionamientoId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> eliminarEstacionamiento(@PathVariable String estacionamientoId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        logger.info("[Eliminando estacionamiento  : ROUTE: /Documento .... Method: eliminarEstacionamiento]");
        try {
            logger.info("[Eliminando..... : ROUTE: /estacionamiento .... Method: eliminarEstacionamiento]");
            return estacionamientorepo.findById(estacionamientoId).map(estacionamiento -> {
                // logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
                estacionamientorepo.delete(estacionamiento);
                logger.info("[Eliminando..... : ROUTE: /estacionamiento .... Method: eliminarEstacionamiento]");
                //logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("estacionamientoId " + estacionamientoId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error eliminando estacionamiento  : ROUTE: /Documento .... Method: eliminarEstacionamiento]");
            return null;
        }
    }

    @PutMapping("/estacionamiento/{estacionamientoId}")
    @ResponseBody
    @JsonFormat
    public void updateEstacionamiento(@PathVariable String estacionamientoId,
                           @Valid @RequestBody Estacionamiento estacionamientorequest) {
        logger.info("[actualizando estacionamiento  : ROUTE: /Documento .... Method: updateEstacionamiento]");
        try {
            logger.info("[actualizando ....  : ROUTE: /Documento .... Method: updateEstacionamiento]");
            estacionamientorepo.findById(estacionamientoId).map(estacionamiento -> {
                estacionamiento.setIdEstacionamiento(estacionamientorequest.getIdEstacionamiento());
                estacionamiento.setNumEstacionamiento(estacionamientorequest.getNumEstacionamiento());
                estacionamiento.setNivelUbicacion(estacionamientorequest.getNivelUbicacion());
                logger.info("[actualizando ....  : ROUTE: /Documento .... Method: updateEstacionamiento]");
                return estacionamientorepo.save(estacionamiento);
            }).orElseThrow(() -> new ResourceNotFoundExcption("estacionamientoId " + estacionamientoId + " not found"));

        } catch (Exception ex) {
            logger.error("[Error actualizando Estacionamiento  : ROUTE: /Documento .... Method: updatePost]");
            ex.getMessage();
            return;
        }
    }
}
