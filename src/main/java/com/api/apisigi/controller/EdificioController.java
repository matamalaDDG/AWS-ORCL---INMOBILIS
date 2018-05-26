package com.api.apisigi.controller;

import com.api.apisigi.entity.Edificio;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IREdificio;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/edificio")
public class EdificioController {

    @Autowired
    @Qualifier("edificioRepo")
    private IREdificio edificiorepo;

    //#LISTAR TODOS: GETMAPPING
    @GetMapping("/edificios")
    @ResponseBody
    @JsonFormat
    public List<Edificio> getRegiones() {
        return edificiorepo.findAll();
    }

    //#LISTAR POR ID: GETMAPPING
    @GetMapping("/{edificioId}/edificios")
    @ResponseBody
    @JsonFormat
    public Page<Edificio> getRegionesById(@PathVariable(value = "comunaId") String idcomuna,
                                          Pageable pageable) {
        return edificiorepo.findByIdEdificio(idcomuna, pageable);
    }

    //#AGREGAR: POSTMAPPIG
    @PostMapping("/nedif")
    @ResponseBody
    @JsonFormat
    public Edificio createEdificio(@Valid @RequestBody Edificio edificio) {
        //logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return edificiorepo.save(edificio);
    }
    //#UPDATE: PUTMAPING
    @PutMapping("/edif/{edificioId}")
    @ResponseBody
    @JsonFormat
    public Edificio updateEdificio(@PathVariable String edificioId,
                             @Valid @RequestBody Edificio edificiorequest) {
        return edificiorepo.findById(edificioId).map(edificio -> {
            edificio.setIdEdificio(edificiorequest.getIdEdificio());
            edificio.setNombreEdi(edificiorequest.getNombreEdi());
            edificio.setNumeroEdificio(edificiorequest.getNumeroEdificio());
            return edificiorepo.save(edificio);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + edificioId + " not found"));
    }
    //#DELETE: DELETEMAPING
    @DeleteMapping("/dedif/{edificioId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String edificioId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return edificiorepo.findById(edificioId).map(edificio -> {
         //   logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            edificiorepo.delete(edificio);
         //   logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + edificioId + " not found"));
    }
}
