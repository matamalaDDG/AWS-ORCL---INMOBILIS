package com.api.apisigi.controller;

import com.api.apisigi.entity.Aseguradora;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRAseguradora;
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
@RequestMapping("/api/propiedades/seguros")
public class AseguradoraController {

    public static final Log logger = LogFactory.getLog(AseguradoraController.class);

    @Autowired
    @Qualifier("aseguradoraRepo")
    private IRAseguradora aseguradorarepo;

    @GetMapping("/aseguradora")
    @ResponseBody
    @JsonFormat
    public List<Aseguradora> getAllAseguradora() {
        logger.info("[Buscando Region : ROUTE: /regiones .... Method: getAllRegiones]");
        try {
            logger.info("[Listando Aseguradora : ROUTE: /Aseguradora .... Method: getAllAseguradora]");
            logger.info("[Aseguradora Listadas : ROUTE: /Aseguradora.... Method: getAllAseguradora]");
            List temp_Aseguradora = new ArrayList<>();
            aseguradorarepo.findAll().forEach(temp_Aseguradora::add);
            //regionre.deleteAll(temp_Regiones);
            return temp_Aseguradora;
        } catch (Exception ex) {
            logger.error("[Error Regiones Listadas : ROUTE: /regiones.... Method: getAllRegiones]" + ex.getMessage());
            return null;
        }

    }

    @PostMapping("/aseguradora")
    @ResponseBody
    @JsonFormat
    public void creandoAseguradora(@Valid @RequestBody Aseguradora aseguradora) {
        logger.info("[creando Aseguradora : ROUTE:  /aseguradora .... Method: creandoAseguradora]");
        try {
            logger.info("[creando ..... : ROUTE: /aseguradora  .... Method: creandoAseguradora]");
            logger.info("[Aseguradora creada : ROUTE: /aseguradora  .... Method: creandoAseguradora]");
            aseguradorarepo.save(aseguradora);
        } catch (Exception ex) {
            logger.error("[Error creando aseguradora : ROUTE: /aseguradora  .... Method: creandoAseguradora]");
            ex.getMessage();
            return;
        }
    }

    @DeleteMapping("/aseguradora/{aseguradoraId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteAseguradora(@PathVariable String aseguradoraId) {
        logger.info("[Eliminando Aseguradora : ROUTE:  /aseguradora .... Method: deleteAseguradora]");
        try {
            logger.info(" eliminando ...  : ROUTE:  /aseguradora .... Method: deleteAseguradora]");
            return aseguradorarepo.findById(aseguradoraId).map(aseguradora -> {
                logger.info("[Aseguradora eliminada  : ROUTE:  /aseguradora .... Method: deleteAseguradora]");
                aseguradorarepo.delete(aseguradora);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + aseguradoraId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error Eliminando Aseguradora : ROUTE:  /aseguradora .... Method: deleteAseguradora]");
            return null;
        }
    }

    @PutMapping("/aseguradora/{aseguradoraId}")
    @ResponseBody
    @JsonFormat
    public void updateAseguradora(@PathVariable String aseguradoraId,
                           @Valid @RequestBody Aseguradora aseguradorarequest) {
        logger.info("[Actualizando Aseguradora  : ROUTE:  /aseguradora .... Method: deleteAseguradora]");
        try {
            logger.info(" Actualizando ...  : ROUTE:  /aseguradora .... Method: deleteAseguradora]");
            aseguradorarepo.findById(aseguradoraId).map(aseguradora -> {
                aseguradora.setIdAseguradora(aseguradorarequest.getIdAseguradora());
                aseguradora.setTipoSeguro(aseguradorarequest.getTipoSeguro());
                aseguradora.setAseguradora(aseguradorarequest.getAseguradora());
                logger.info("[Aseguradora Actualizanda  : ROUTE:  /aseguradora .... Method: deleteAseguradora]");
                return aseguradorarepo.save(aseguradora);
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + aseguradoraId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error Actualizando Aseguradora : ROUTE:  /aseguradora .... Method: deleteAseguradora]");
            ex.getMessage();
            return;
        }
    }

}
