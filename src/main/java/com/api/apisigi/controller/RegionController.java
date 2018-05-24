package com.api.apisigi.controller;

import com.api.apisigi.entity.Region;
import com.api.apisigi.model.MRegion;
import com.api.apisigi.service.SRegion;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    //#LOG
    public static final Log logger = LogFactory.getLog(ArriendoController.class);

    @Autowired
    @Qualifier("regionService")
    private SRegion regionservice;

    //#GET
    @GetMapping("/list")
    @ResponseBody
    public List<MRegion> Region() {
        logger.info("[Request_Type: GET] -- FROM: region '/list' -- Status: '200']");
        return regionservice.read();
    }

    //#POST
    @PostMapping("/nregion")
    @ResponseBody
    public boolean agregarRegion(@RequestBody @Valid Region region) {
        logger.info("[Request_Type: POST] -- FROM: region '/region' -- Status: '201']");
        return regionservice.create(region);
    }
    //#PUT
    //#DELETE
}
