package com.api.apisigi.controller;

import com.api.apisigi.entity.Region;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRRegion;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/ubicacion/region")
public class RegionController {

    public static final Log logger = LogFactory.getLog(RegionController.class);

    @Autowired
    @Qualifier("regionRepo")
    private IRRegion regionre;


    @GetMapping("/regiones")
    @ResponseBody
    @JsonFormat
    public List<Region> getAllRegiones() {
        logger.info("[Buscando Region : ROUTE: /regiones .... Method: getAllRegiones]");
        logger.info("[Listando Regiones : ROUTE: /regiones .... Method: getAllRegiones]");
        logger.info("[Regiones Listadas : ROUTE: /regiones.... Method: getAllRegiones]");
        List temp_Regiones = new ArrayList<>();
        regionre.findAll().forEach(temp_Regiones::add);
        return temp_Regiones;

        //return regionre.findAll().;

    }

    //#ROUTE METHODS
    //#POST METHOD: INSERCION REGION
    @PostMapping("/nregion")
    @ResponseBody
    @JsonFormat
    public void createRegion(@Valid @RequestBody Region region) {
        logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        regionre.save(region);
    }

    @DeleteMapping("/dregion/{regionId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String regionId) {
        logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return regionre.findById(regionId).map(region -> {
            logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            regionre.delete(region);
            logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + regionId + " not found"));
    }

    //#UPDATE REGION
    @PutMapping("/region/{regionId}")
    @ResponseBody
    @JsonFormat
    public Region updatePost(@PathVariable String regionId,
                             @Valid @RequestBody Region regionRequest) {
        return regionre.findById(regionId).map(region -> {
            region.setRegion(regionRequest.getRegion());
            region.setIdRegion(regionRequest.getIdRegion());
            return regionre.save(region);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + regionId + " not found"));
    }


}
