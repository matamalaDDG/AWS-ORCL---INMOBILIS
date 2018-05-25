package com.api.apisigi.controller;


import com.api.apisigi.entity.Comuna;
import com.api.apisigi.model.MComuna;
import com.api.apisigi.service.SComuna;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comuna")
public class ComunaController {
    //#LOG
    public static final Log logger = LogFactory.getLog(ArriendoController.class);

    @Autowired
    @Qualifier("comunaService")
    private SComuna comunaservice;

    //#GET
    @GetMapping("/list")
    @ResponseBody
        public List<MComuna> getArriendo(){
            logger.info("[Request_Type: GET] -- FROM: COMUNA '/list' -- Status: '200']");
                return comunaservice.read();
        }
    //#POST
    @PostMapping("/ncomuna")
    @ResponseBody
    public boolean agregarRegion(@RequestBody @Valid Comuna comuna ) {
        logger.info("[Request_Type: POST] -- FROM: COMUNA '/region' -- Status: '201']");
        return comunaservice.create(comuna);
    }
    //#PUT
    //#DELETE

}
