package com.api.apisigi.controller;

import com.api.apisigi.entity.TipoPropiedad;
import com.api.apisigi.repository.IRTipoPropiedad;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipopropiedad")
public class TipopropiedadController {

    @Autowired
    @Qualifier("tipoPropiedadRepo")
    private IRTipoPropiedad tipopropiedadrepo;

    //#LISTADO DE COMUNAS POR ID COMUNA
    //#GET METHOD
    @GetMapping("/comunas")
    @ResponseBody
    @JsonFormat
    public List<TipoPropiedad> getAll() {
        return tipopropiedadrepo.findAll();
    }

}
