package com.api.apisigi.controller;

import com.api.apisigi.entity.Estado;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IREstado;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    @Qualifier("estadoRepo")
    private IREstado estadorepo;

    //#GET METHOD
    @GetMapping("/estados")
    @ResponseBody
    @JsonFormat
    public List<Estado> getAll() {
        return estadorepo.findAll();
    }

    @PostMapping("/Nestados")
    @ResponseBody
    @JsonFormat
    public Estado createRegion(@Valid @RequestBody Estado estado) {
        // logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return estadorepo.save(estado);
    }


    @DeleteMapping("/destado/{estadoId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String estadoId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return estadorepo.findById(estadoId).map(estado -> {
            // logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            estadorepo.delete(estado);
            //logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + estadoId + " not found"));
    }

    @PutMapping("/region/{regionId}")
    @ResponseBody
    @JsonFormat
    public Estado updatePost(@PathVariable String estadoId,
                                    @Valid @RequestBody Estado estadorequest) {
        return estadorepo.findById(estadoId).map(estado -> {
            estado.setIdEstado(estadorequest.getIdEstado());
            estado.setEstado(estadorequest.getEstado());
            return estadorepo.save(estado);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + estadoId + " not found"));
    }
}
