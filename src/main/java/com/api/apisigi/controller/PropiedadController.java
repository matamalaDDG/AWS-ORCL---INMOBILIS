package com.api.apisigi.controller;

import com.api.apisigi.entity.Propiedad;
import com.api.apisigi.repository.IRPropiedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inmobiliaria/propiedades")
public class PropiedadController {
    //TODO Comenzar controlador propiedad completo

    @Autowired
    @Qualifier("propiedadRepo")
    private IRPropiedad propiedadrepo;


}
