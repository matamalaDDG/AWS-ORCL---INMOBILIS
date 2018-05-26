package com.api.apisigi.controller;

import com.api.apisigi.entity.Region;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRRegion;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class RegionController {

    public static final Log logger = LogFactory.getLog(RegionController.class);

    @Autowired
    private IRRegion regionre;

    @GetMapping("/regiones")
    @ResponseBody
    @JsonFormat
    public List<Region> getAllPosts() {
        return regionre.findAll();
    }

    @PostMapping("/nregion")
    @ResponseBody
    @JsonFormat
    public Region createRegion(@Valid @RequestBody Region region) {
        logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return regionre.save(region);
    }

    @DeleteMapping("/dregion/{regionId}")
    public ResponseEntity<?> deletePost(@PathVariable String regionId) {
        logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return regionre.findById(regionId).map(region -> {
            logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            regionre.delete(region);
            logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + regionId + " not found"));
    }
}
