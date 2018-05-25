package com.api.apisigi.PruebaController;

import com.api.apisigi.PruebaService.SRegionT;
import com.api.apisigi.pruebaEntity.Region;
import com.api.apisigi.pruebaModel.MRegionT;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/TRegionCtrllr")
public class RegionTController {
    //#LOG
    public static final Log logger = LogFactory.getLog(RegionTController.class);

    @Autowired
    @Qualifier("regionTService")
    private SRegionT regionTservice;

    //#GET
    @GetMapping("/list")
    @ResponseBody
    public List<MRegionT> Region() {
        logger.info("[Request_Type: GET] -- FROM: region '/list' -- Status: '200']");
        return regionTservice.read();
    }

    //#POST
    @PostMapping("/nregion")
    @ResponseBody
    public boolean agregarRegion(@RequestBody @Valid Region region) {
        logger.info("[Request_Type: POST] -- FROM: region '/region' -- Status: '201']");
        return regionTservice.create(region);
    }
}
