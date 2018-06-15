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
import java.util.List;
import java.util.Optional;

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
        logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
        try {
            return patentecomercialrepo.findAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @PostMapping("/patente")
    @ResponseBody
    @JsonFormat
    public void createPatente(@RequestBody PatenteComercial patente) {
        try {
            patentecomercialrepo.save(patente);
        } catch (Exception ex) {
        }
    }

    @DeleteMapping("/patente/{idpatente}")
    @ResponseBody
    @JsonFormat
    public void deletePatente(@RequestParam String idPatente) {
        try {
            patentecomercialrepo.deleteById(idPatente);
        } catch (Exception ex) {

        }
    }

    @PutMapping("/patente/{idpatente}")
    @ResponseBody
    @JsonFormat
    public PatenteComercial updatePost(@PathVariable String idpatente,
                                       @Valid @RequestBody PatenteComercial patenteRequest) {
        return patentecomercialrepo.findById(idpatente).map(patenteComercial -> {
            patenteComercial.setTipoPatente(patenteRequest.getTipoPatente());
            return patentecomercialrepo.save(patenteComercial);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + idpatente + " not found"));
    }
}
