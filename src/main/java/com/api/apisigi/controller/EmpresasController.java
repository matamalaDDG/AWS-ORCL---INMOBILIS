package com.api.apisigi.controller;

import com.api.apisigi.entity.Empresas;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IREmpresas;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/convenio/empresas")
public class EmpresasController {

    //    INYECCION DE DEPENDENCIAS
    @Autowired
    @Qualifier("empresasRepo")
    private IREmpresas empresasrepo;

    //    GET MAPPING
    @GetMapping("/empresas")
    @ResponseBody
    @JsonFormat
    public List<Empresas> getAll() {
        return empresasrepo.findAll();
    }

    //    POST MAPPING
    @PostMapping("/nempresa")
    @ResponseBody
    @JsonFormat
    public Empresas createRegion(@Valid @RequestBody Empresas empresas) {
        // logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return empresasrepo.save(empresas);
    }

    //    UPDATE MAPPING
    @PutMapping("/uempresa/{empresasId}")
    @ResponseBody
    @JsonFormat
    public Empresas updatePost(@PathVariable String empresasId,
                               @Valid @RequestBody Empresas empresasrequest) {
        return empresasrepo.findById(empresasId).map(empresas -> {
            empresas.setIdEmpresa(empresasrequest.getIdEmpresa());
            empresas.setNombreEmpresa(empresasrequest.getNombreEmpresa());
            return empresasrepo.save(empresas);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + empresasId + " not found"));
    }

    //    DELETE MAPPING
    @DeleteMapping("/dempresas/{empresasId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String empresasId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return empresasrepo.findById(empresasId).map(empresas -> {
            // logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            empresasrepo.delete(empresas);
            //logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + empresasId + " not found"));
    }

}
