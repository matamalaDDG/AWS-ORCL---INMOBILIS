package com.api.apisigi.PruebaController;

import com.api.apisigi.PruebaService.SComunaT;
import com.api.apisigi.pruebaEntity.Comuna;
import com.api.apisigi.pruebaModel.MComunaT;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/TComunaCtrllr")
public class ComunaTController {

    //#LOG
    public static final Log logger = LogFactory.getLog(ComunaTController.class);

    @Autowired
    @Qualifier("comunaTService")
    private SComunaT regionservice;

    //#GET
    @GetMapping("/listT")
    @ResponseBody
    public List<MComunaT> Region() {
        logger.info("[Request_Type: GET] -- FROM: Tcomuna '/listT' -- Status: '200']");
        return regionservice.read();
    }

    //#POST
    @PostMapping("/ncomunaT")
    @ResponseBody
    public boolean agregarRegion(@RequestBody @Valid Comuna comuna) {
        logger.info("[Request_Type: POST] -- FROM: Tcomuna '/ncomunaT' -- Status: '201']");
        return regionservice.create();
    }
}
