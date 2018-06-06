package com.api.apisigi.controller;

import com.api.apisigi.entity.Servicios;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRAseguradora;
import com.api.apisigi.repository.IRServicios;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/venta/proceso/contrato/servicios")
public class ServiciosController {

    //   INYECCION DE DEPENDENCIAS
    @Autowired
    @Qualifier("servicioRepo")
    private IRServicios serviciosrepo;

    //GET METHOD
    @GetMapping("/sevicios")
    @ResponseBody
    @JsonFormat
    public List<Servicios> getAll() {
        return serviciosrepo.findAll();
    }

    //POST METHOD
    @PostMapping("/nServicio")
    @ResponseBody
    @JsonFormat
    public Servicios createRegion(@Valid @RequestBody Servicios servicios) {
        // logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return serviciosrepo.save(servicios);
    }

    // PUT METHOD
    @PutMapping("/uservicio/{servicioId}")
    @ResponseBody
    @JsonFormat
    public Servicios updatePost(@PathVariable String servicioId,
                                @Valid @RequestBody Servicios serviciosrequest) {
        return serviciosrepo.findById(servicioId).map(servicios -> {
            servicios.setIdServicio(serviciosrequest.getIdServicio());
            servicios.setServicio(serviciosrequest.getServicio());
            servicios.setValorServicio(serviciosrequest.getValorServicio());
            return serviciosrepo.save(servicios);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + servicioId + " not found"));
    }

    //  DELETE METHOD
    @DeleteMapping("/dservicio/{servicioId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String servicioId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return serviciosrepo.findById(servicioId).map(servicios -> {
            // logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            serviciosrepo.delete(servicios);
            //logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + servicioId + " not found"));
    }
}
