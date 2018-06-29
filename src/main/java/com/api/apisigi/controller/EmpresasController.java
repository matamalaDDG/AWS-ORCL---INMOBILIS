package com.api.apisigi.controller;

import com.api.apisigi.entity.Empresas;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IREmpresas;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/convenio/externos")
public class EmpresasController {
    public static final Log logger = LogFactory.getLog(RolesController.class);

    //    INYECCION DE DEPENDENCIAS
    @Autowired
    @Qualifier("empresasRepo")
    private IREmpresas empresasrepo;

    //    GET MAPPING
    @GetMapping("/empresas")
    @ResponseBody
    @JsonFormat
    public List<Empresas> getAllEmpresas() {
        try {
            logger.info("[Buscando Empresas : ROUTE: /empresas .... Method: getAllEmpresas]");
            logger.info("[Listando Empresas : ROUTE: /empresas .... Method: getAllEmpresas]");
            logger.info("[Empresas Listados : ROUTE: /empresas.... Method: getAllEmpresas]");
            List temp_empresas = new ArrayList<>();
            empresasrepo.findAll().forEach(temp_empresas::add);

            return temp_empresas;

        } catch (Exception ex) {

            logger.error("[Error Listado Empresas : ROUTE: /empresas.... Method: getAllEmpresas]" + ex.getMessage());
            return null;
        }
    }

    //    POST MAPPING
    @PostMapping("/empresa")
    @ResponseBody
    @JsonFormat
    public void createRegion(@Valid @RequestBody Empresas empresas) {
        try {
            logger.info("[creando empresa : ROUTE: .... Method: createRegion]");
            logger.info("[empresa creada : ROUTE: .... Method: createRegion]");
             empresasrepo.save(empresas);
        } catch (Exception ex) {
            logger.error("[Error creando Empresas : ROUTE: /empresas.... Method: getAllEmpresas]" + ex.getMessage());
            return ;
        }

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
