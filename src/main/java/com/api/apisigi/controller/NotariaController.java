package com.api.apisigi.controller;

import com.api.apisigi.entity.Notaria;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRNotaria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notaria")
public class NotariaController {
    @Autowired
    @Qualifier("notariaRepo")
    private IRNotaria noratiarepo;

    //#ROUTE METHODS
    //#POST METHOD: INSERCION DEPARTAMENTO + IDEDIFICIO
    @PostMapping("/nNotaria")
    @ResponseBody
    @JsonFormat
    public Notaria createNotaria(@Valid @RequestBody Notaria notaria) {
        // logger.info("[creando Notaria : ROUTE: /dNotaria/{NotariaId}.... Method: createNotaria]");
        return noratiarepo.save(notaria);
    }

    //#GET METHOD: LISTADO DE NOTARIAS
    @GetMapping("/notarias")
    @ResponseBody
    @JsonFormat
    public List<Notaria> getAllNotarias() {
        return noratiarepo.findAll();
    }

    //#DELETE METHOD: ELIMINAR NOTARIA
    @DeleteMapping("/dnotaria/{notariaId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteNotaria(@PathVariable String notariaId) {
        //logger.info("[buscado Notaria : /dNotaria/{NotariaId}.... Method: deletePost]");
        return noratiarepo.findById(notariaId).map(notaria -> {
            //logger.info("[Eliminando Notaria  Notaria : /dNotaria/{NotariaId}.... Method: deletePost]");
            noratiarepo.delete(notaria);
            //logger.info("[Notaria eliminada: /dNotaria/{NotariaId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + notariaId + " not found"));
    }

    //#UPDATE METHOD: ACTUALIZAR O MODIFICAR
    @PutMapping("/unotaria/{notariaId}")
    @ResponseBody
    @JsonFormat
    public Notaria updateNotaria(@PathVariable String notariaId,
                                 @Valid @RequestBody Notaria notariaRequest) {
        return noratiarepo.findById(notariaId).map(notaria -> {
            notaria.setIdNotaria(notariaRequest.getIdNotaria());
            notaria.setDescripcion(notariaRequest.getDescripcion());
            return noratiarepo.save(notaria);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + notariaId + " not found"));
    }
}
