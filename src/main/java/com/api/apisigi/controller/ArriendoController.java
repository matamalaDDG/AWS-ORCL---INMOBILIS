package com.api.apisigi.controller;

import com.api.apisigi.entity.Arriendo;
import com.api.apisigi.model.MArriendo;
import com.api.apisigi.service.SArriendo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/arriendo")
public class ArriendoController {
    //#LOG
    public static final Log logger = LogFactory.getLog(ArriendoController.class);

    //#INJECCION DE DEPENDENCIAS
    @Autowired
    @Qualifier("arriendoService")
    private SArriendo arriendoservice;

    //##GET
    @GetMapping("/all")
    @ResponseBody
    public List<MArriendo> listarArriendos() {
        //#LOG
        logger.info("[Request_Type: GET] -- FROM: '/arriendo' -- Status: '200']");
        return arriendoservice.listadoArrinedos();
    }
    //#POST
    @PostMapping("/nuevoarriendo")
    public boolean createArriendo(@RequestBody @Valid Arriendo arriendo){
        logger.info("[Request_Type: GET] -- FROM: '/arriendo' -- Status: '200']");
        return arriendoservice.crear(arriendo);
    }

    //#PUT
    //#DELETE
}
