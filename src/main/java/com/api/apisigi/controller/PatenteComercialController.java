package com.api.apisigi.controller;

import com.api.apisigi.entity.PatenteComercial;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRPatenteComercial;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/tipo/oficina/patentecomercial")
public class PatenteComercialController {

    public static final Log logger = LogFactory.getLog(PatenteComercialController.class);

    //#DEPENDENCI INJECTION AREA
    @Autowired
    @Qualifier("patenteComercialRepo")
    private IRPatenteComercial patentecomercialrepo;

    //#REQUEST AREA
    //#GETMAPPING
    @GetMapping("/patentecomerciales")
    @ResponseBody
    @JsonFormat
    public List<PatenteComercial> getpatentecomercial() {
        logger.info("[Listando PatenteComercial : /dregion/{regionId}.... Method: getpatentecomercial]");
        try {
            logger.info("[PatenteComercial Listadas : /PatenteComercial .... Method: getpatentecomercial]");
            List temp_PatenteComercial = new ArrayList<>();
            patentecomercialrepo.findAll().forEach(temp_PatenteComercial::add);
            //regionre.deleteAll(temp_Regiones);
            return temp_PatenteComercial;
            //return regionre.findAll().;
        } catch (Exception ex) {
            logger.error("[Erroe al listar  PatenteComercial : /PatenteComercial .... Method: getpatentecomercial]");
            return null;
        }
    }

    @PostMapping("/patente")
    @ResponseBody
    @JsonFormat
    public void createPatente(@RequestBody PatenteComercial patente) {
        logger.info("[creando PatenteComercial : ROUTE: .... Method: createRegion]");
        try {
            logger.info("[PatenteComercial creada : ROUTE: .... Method: createRegion]");
            patentecomercialrepo.save(patente);
        } catch (Exception ex) {
            logger.error("[Erroe al crear PatenteComercial : /PatenteComercial .... Method: getpatentecomercial]");
            ex.getMessage();
            return;
        }
    }

    @DeleteMapping("/patente/{idpatente}")
    @ResponseBody
    @JsonFormat
    public void deletePatente(@RequestParam String idPatente) {
        logger.info("[Eliminando PatenteComercial : ROUTE:/patente .... Method: deletePatente]");
        try {
            logger.info("[PatenteComercial Eliminada : ROUTE:/patente .... Method: deletePatente]");
            patentecomercialrepo.deleteById(idPatente);
        } catch (Exception ex) {
            logger.error("[Erroe eliminado PatenteComercial : ROUTE: .... Method: deletePatente]");
            ex.getMessage();
            return;
        }
    }

    @PutMapping("/patente/{idpatente}")
    @ResponseBody
    @JsonFormat
    public void updatePost(@PathVariable String idpatente,
                                       @Valid @RequestBody PatenteComercial patenteRequest) {
        logger.info("[PatenteComercial Modificada : ROUTE:/patente .... Method: deletePatente]");
        try {
            logger.info("[Modificando PatenteComercial Eliminada : ROUTE:/patente .... Method: deletePatente]");
            patentecomercialrepo.findById(idpatente).map(patenteComercial -> {
                patenteComercial.setTipoPatente(patenteRequest.getTipoPatente());
                logger.info("[PatenteComercial Eliminada : ROUTE:/patente .... Method: deletePatente]");

                return patentecomercialrepo.save(patenteComercial);
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + idpatente + " not found"));
        } catch (Exception ex) {
            logger.error("[Erroe eliminado PatenteComercial : ROUTE: .... Method: deletePatente]");
        ex.getMessage();
            return;
        }
    }
}
