package com.api.apisigi.controller;

import com.api.apisigi.entity.Oficina;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IROficina;
import com.api.apisigi.repository.IRPatenteComercial;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propiedad/tipo/oficina")
public class OficinaController {

    public static final Log logger = LogFactory.getLog(EstacionamientoController.class);

    @Autowired
    @Qualifier("oficinaRepo")
    private IROficina oficinarepo;

    @Autowired
    @Qualifier("patenteComercialRepo")
    private IRPatenteComercial patenterepo;

    //#LISTADO DE COMUNA
    @GetMapping("/oficinas")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @JsonFormat
    public List<Oficina> getAll() {
        return oficinarepo.findAll();
    }

    //#AGREGAR COMUNAS NUEVAS CON RELACION DE REGION
    @PostMapping("/patente/{idpatente}/oficina")
    @ResponseBody
    @JsonFormat
    public void createOficina(@PathVariable(value = "idpatente") String idpatente,
                              @Valid @RequestBody Oficina oficina) {
        if (!patenterepo.existsById(idpatente)) {
            logger.error("[Error Oficina Listadas : ROUTE: /Oficina.... Method: createOficina]");
            throw new ResourceNotFoundExcption("patenteid " + idpatente + " not found");
        }
        logger.info("[Creando Oficina : ROUTE: /Oficina .... Method: createOficina]");

        try {
            logger.info("[Creando..... : ROUTE: /Oficina .... Method: createOficina]");

            patenterepo.findById(idpatente).map((patente) -> {
                //TODO Agregar LOGS
                oficina.setPatenteComercial(patente);
                logger.info("[Oficina Creado : ROUTE: /Documento .... Method: createOficina]");
                oficinarepo.save(oficina);
                return oficina;
            }).orElseThrow(() -> new ResourceNotFoundExcption("idpatente " + idpatente + " not found"));
        } catch (Exception ex) {
            logger.error("[Error Oficina Listadas : ROUTE: /Oficina.... Method: createOficina]");
            logger.error(ex.getMessage());
            return;
        }
    }

    //    PUT MAPPING:
    //# PUTCONTROLLER
    @PutMapping("/patente/{patenteid}/oficina/{oficinaid}")
    @ResponseBody
    @JsonFormat
    public void updateOficina(@PathVariable(value = "patenteid") String patenteid,
                              @PathVariable(value = "oficinaid") String oficinaid,
                              @Valid @RequestBody Oficina oficinaRequest) {

        if (!patenterepo.existsById(patenteid)) {
            logger.error("[Error patenteid  : ROUTE: /Oficina .... Method: updateOficina]");
            throw new ResourceNotFoundExcption("patenteid " + patenteid + " not found");
        }
        logger.info("[Actualizando Oficina  : ROUTE: /Oficina .... Method: updateOficina]");

        try {
            logger.info("[Actualizando Oficina  : ROUTE: /Oficina .... Method: updateOficina]");

            oficinarepo.findById(oficinaid).map(oficina -> {
                oficina.setMtsCuadDisp(oficinaRequest.getMtsCuadDisp());
                oficina.setNumOficina(oficinaRequest.getNumOficina());
                logger.info("[Oficina Actualizando   : ROUTE: /Oficina .... Method: updateOficina]");
                return oficinarepo.save(oficina);
            }).orElseThrow(() -> new ResourceNotFoundExcption("oficinaid " + oficinaid + "not found"));
        } catch (Exception ex) {
            logger.error("[Error Actualizando estacionamiento  : ROUTE: /Oficina .... Method: updateOficina]");
            return;
        }
    }

    //    DELETE MAPPING:
    //# ELIMINAR UNA COMUNA
    @DeleteMapping("/patente/{patenteid}/oficina/{oficinaid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteOficina(@PathVariable(value = "patenteid") String patenteid,
                                           @PathVariable(value = "oficinaid") String oficinaid) {
        if (!patenterepo.existsById(patenteid)) {
            throw new ResourceNotFoundExcption("patenteid " + patenteid + " not found");
        }
        logger.info("[Eliminada Oficina  : ROUTE: /Oficina .... Method: deleteOficina]");
        try {
            logger.info("[Eliminada.....  : ROUTE: /Oficina .... Method: deleteOficina]");
            return oficinarepo.findById(oficinaid).map(comuna -> {
                logger.info("[ Oficina Eliminada  : ROUTE: /Oficina .... Method: deleteOficina]");
                oficinarepo.delete(comuna);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + oficinaid + " not found"));
        } catch (Exception ex) {
            logger.error("[Error Eliminando oficina  : ROUTE: /oficina .... Method: deleteOficina]");
            return null;
        }
    }

}
