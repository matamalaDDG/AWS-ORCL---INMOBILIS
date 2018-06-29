package com.api.apisigi.controller;

import com.api.apisigi.entity.Bodega;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRBodega;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/tipo/bodega")
public class BodegaController {
    public static final Log logger = LogFactory.getLog(BodegaController.class);

    //#DEPENDENCI INJECTION AREA
    @Autowired
    @Qualifier("bodegaRepo")
    private IRBodega bodegarepo;

    //#lOGS

    //#REQUEST AREA
    //#GETMAPPING
    @GetMapping("/bodegas")
    @ResponseBody
    @JsonFormat
    public List<Bodega> getBodegas() {
        return bodegarepo.findAll();
    }

            //#POSTMAPPING
    @PostMapping("/bodega")
    @ResponseBody
    @JsonFormat
    public void createBodega(@Valid @RequestBody Bodega bodega) {
        logger.info("[creando Bodega : ROUTE: /bodegas.... Method: createBodega]");
        try {
            logger.info("[creando Bodega : ROUTE: .... Method: createBodega]");
            logger.info("[Bodega creada : ROUTE: .... Method: createBodega]");
            bodegarepo.save(bodega);
        } catch (Exception ex) {
            logger.error("[Error creando bodega  : ROUTE: .... Method: createBodega]");
            return;
        }
    }

    //#UPDATEMAPPING
    @PutMapping("/ebodega/{bodegaId}")
    @ResponseBody
    @JsonFormat
    public Bodega updateEdificio(@PathVariable String bodegaId,
                                 @Valid @RequestBody Bodega bodegarequest) {
        return bodegarepo.findById(bodegaId).map(bodega -> {
            bodega.setIdBodega(bodegarequest.getIdBodega());
            bodega.setNumIdentBodega(bodegarequest.getNumIdentBodega());
            bodega.setMtsCuad(bodegarequest.getMtsCuad());
            int random = (int)(Math.random() * 999999 + 1);
            return bodegarepo.save(bodega);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + bodegaId + " not found"));
    }
    //#DELETEMAPPING
    @DeleteMapping("/dbodega/{bodegaId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String bodegaId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return bodegarepo.findById(bodegaId).map(bodega -> {
            //   logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            bodegarepo.delete(bodega);
            //   logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + bodegaId + " not found"));
    }
}
