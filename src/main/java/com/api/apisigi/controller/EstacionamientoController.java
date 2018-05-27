package com.api.apisigi.controller;

import com.api.apisigi.entity.Estacionamiento;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IREstacionamiento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estacionamiento")
public class EstacionamientoController {

    @Autowired
    @Qualifier("estacionamientoRepo")
    private IREstacionamiento estacionamientorepo;

    @GetMapping("/estacionamientos")
    @ResponseBody
    @JsonFormat
    public List<Estacionamiento> getAll() {
        return estacionamientorepo.findAll();
    }

    @PostMapping("/nestacionamiento")
    @ResponseBody
    @JsonFormat
    public Estacionamiento createEstacionamiento(@Valid @RequestBody Estacionamiento estacionamiento) {
        // logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return estacionamientorepo.save(estacionamiento);
    }

    @DeleteMapping("/destacionamiento/{estacionamientoId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> eliminarEstacionamiento(@PathVariable String estacionamientoId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return estacionamientorepo.findById(estacionamientoId).map(estacionamiento -> {
            // logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            estacionamientorepo.delete(estacionamiento);
            //logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("estacionamientoId " + estacionamientoId + " not found"));
    }

    @PutMapping("/region/{regionId}")
    @ResponseBody
    @JsonFormat
    public Estacionamiento updatePost(@PathVariable String estacionamientoId,
                                      @Valid @RequestBody Estacionamiento estacionamientorequest) {
        return estacionamientorepo.findById(estacionamientoId).map(estacionamiento -> {
            estacionamiento.setIdEstacionamiento(estacionamientorequest.getIdEstacionamiento());
            estacionamiento.setNumEstacionamiento(estacionamientorequest.getNumEstacionamiento());
            estacionamiento.setNivelUbicacion(estacionamientorequest.getNivelUbicacion());
            return estacionamientorepo.save(estacionamiento);
        }).orElseThrow(() -> new ResourceNotFoundExcption("estacionamientoId " + estacionamientoId + " not found"));
    }
}
