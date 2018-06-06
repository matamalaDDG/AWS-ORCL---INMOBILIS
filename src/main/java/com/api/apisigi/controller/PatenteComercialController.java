package com.api.apisigi.controller;

import com.api.apisigi.entity.PatenteComercial;
import com.api.apisigi.repository.IRPatenteComercial;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propiedades/tipo/oficina/patentecomercial")
public class PatenteComercialController {

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
        return patentecomercialrepo.findAll();
    }

    @GetMapping("/{patentecomercialId}/patentecomercial")
    @ResponseBody
    @JsonFormat
    public Optional<PatenteComercial> getPatenteComercialById(@PathVariable String patentecomercialId) {
            return patentecomercialrepo.findById(patentecomercialId);
    }

}
