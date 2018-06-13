package com.api.apisigi.controller;

import com.api.apisigi.entity.Bodega;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRBodega;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/tipo/bodega")
public class BodegaController {
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
    @PostMapping("/nbodega")
    @ResponseBody
    @JsonFormat
    public Bodega createEdificio(@Valid @RequestBody Bodega bodega) {
        //logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return bodegarepo.save(bodega);
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
