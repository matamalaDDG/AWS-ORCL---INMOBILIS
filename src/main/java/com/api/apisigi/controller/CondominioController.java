package com.api.apisigi.controller;

import com.api.apisigi.entity.Condominio;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRCondominio;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propiedad/tipo/")
public class CondominioController {


    @Autowired
    @Qualifier("condominioRepo")
    private IRCondominio condomioniorepo;

    //#REQUEST AREA
    //#GETMAPPING
    @GetMapping("/condominios")
    @ResponseBody
    @JsonFormat
    public List<Condominio> getBodegas() {
        return condomioniorepo.findAll();
    }

    //#POSTMAPPING
    @PostMapping("/ncondominio")
    @ResponseBody
    @JsonFormat
    public void  createEdificio(@Valid @RequestBody Condominio condominio) {
        //logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        try{
            int random = (int)(Math.random() * 999999 + 1);
            String id = "COND"+ random;
            condominio.setIdCondominio(id);
            condomioniorepo.save(condominio);
        }catch (Exception ex){
            return;
        }

    }

    //#UPDATEMAPPING
    @PutMapping("/econdominio/{condominioId}")
    @ResponseBody
    @JsonFormat
    public Condominio updateEdificio(@PathVariable String condominioId,
                                     @Valid @RequestBody Condominio condomioniorequest) {
        return condomioniorepo.findById(condominioId).map(condominio -> {
            condominio.setIdCondominio(condomioniorequest.getIdCondominio());
            condominio.setNombre(condomioniorequest.getNombre());
            condominio.setNumeroCond(condomioniorequest.getNumeroCond());
            return condomioniorepo.save(condominio);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + condominioId + " not found"));
    }

    //#DELETEMAPPING
    @DeleteMapping("/dcondominio/{condominioId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String condominioId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return condomioniorepo.findById(condominioId).map(condominio -> {
            //   logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            condomioniorepo.delete(condominio);
            //   logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + condominioId + " not found"));
    }


}
