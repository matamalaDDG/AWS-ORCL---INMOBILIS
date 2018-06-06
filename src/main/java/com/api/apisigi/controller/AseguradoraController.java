package com.api.apisigi.controller;

import com.api.apisigi.entity.Aseguradora;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRAseguradora;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/seguros")
public class AseguradoraController {
    @Autowired
    @Qualifier("aseguradoraRepo")
    private IRAseguradora aseguradorarepo;

    @GetMapping("/aseguradora")
    @ResponseBody
    @JsonFormat
    public List<Aseguradora> getAll() {

        return aseguradorarepo.findAll();

    }

    @PostMapping("/naseguradora")
    @ResponseBody
    @JsonFormat
    public Aseguradora createRegion(@Valid @RequestBody Aseguradora aseguradora) {
        // logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return aseguradorarepo.save( aseguradora );
    }

    @DeleteMapping("/daseguradora/{aseguradoraId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String aseguradoraId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return aseguradorarepo.findById(aseguradoraId).map(aseguradora -> {
            // logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            aseguradorarepo.delete(aseguradora);
            //logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + aseguradoraId + " not found"));
    }

    @PutMapping("/uaseguradora/{aseguradoraId}")
    @ResponseBody
    @JsonFormat
    public Aseguradora updatePost(@PathVariable String aseguradoraId,
                                  @Valid @RequestBody Aseguradora aseguradorarequest) {
        return aseguradorarepo.findById(aseguradoraId).map(aseguradora -> {
            aseguradora.setIdAseguradora(aseguradorarequest.getIdAseguradora());
            aseguradora.setTipoSeguro(aseguradorarequest.getTipoSeguro());
            aseguradora.setAseguradora(aseguradorarequest.getAseguradora());
            return aseguradorarepo.save(aseguradora);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + aseguradoraId + " not found"));
    }

}
