package com.api.apisigi.controller;

import com.api.apisigi.entity.Departamento;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDepartamento;
import com.api.apisigi.repository.IREdificio;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pripiedad/tipo/departamento")
public class DepartamentoController {
    public static final Log logger = LogFactory.getLog(DepartamentoController.class);

    @Autowired
    @Qualifier("departamentoRepo")
    private IRDepartamento departatamentorepo;
    @Autowired
    @Qualifier("edificioRepo")
    private IREdificio edificiorepo;

    //#ROUTE METHODS
    //#POST METHOD: INSERCION DEPARTAMENTO + IDEDIFICIO
    @PostMapping("/edificio/{idEdificio}/departamento")
    @ResponseBody
    @JsonFormat
    public void createDepartamento(@PathVariable(value = "idEdificio") String idEdificio,
                                   @Valid @RequestBody Departamento departamento) {
        if (!edificiorepo.existsById(idEdificio)) {
            logger.info("[edificio no existe : ROUTE: /departamento .... Method: createDepartamento]");
            throw new ResourceNotFoundExcption("idempresa " + idEdificio + " not found");
        }
        logger.info("[Agregando Departamento : ROUTE: /Departamento .... Method: createDepartamento]");
        try {
            logger.info("[Incertando Departamento : ROUTE: /Departamento .... Method: createDepartamento]");
            departatamentorepo.save(
                    edificiorepo.findById(idEdificio).map(edificio -> {
                        departamento.setEdificio(edificio);
                        logger.info("[ Departamento  Agregado: ROUTE: /Departamento .... Method: createDepartamento]");
                        return departamento;
                    }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idEdificio + " not found"))
            );
        } catch (Exception ex) {
            logger.error("[Error Agregando Departamento  : ROUTE: /Departamento .... Method: createDepartamento]");
            ex.getMessage();
            return;
        }


    }

    //#LISTADO DE DEPARTAMENTOS
    @GetMapping("/departamentos")
    @ResponseBody
    @JsonFormat
    public List<Departamento> getAllDepartamento() {
        logger.info("[Listando Departamento : ROUTE: /Departamento .... Method: getAllDepartamento]");
        try {
            logger.info("[Departamento Listados : ROUTE: /Departamento.... Method: getAllDepartamento]");
            List temp_Regiones = new ArrayList<>();
            departatamentorepo.findAll().forEach(temp_Regiones::add);
            //regionre.deleteAll(temp_Regiones);
            return temp_Regiones;
        } catch (Exception ex) {
            logger.error("[Error Listando Departamento : ROUTE: /Departamento .... Method: getAllDepartamento]");
            ex.getMessage();
            return null;
        }
    }

    //#PUT METHOD: ACTUALIZACION DE DEPARTAMENTO
    @PutMapping("/edificio/{edificioId}/departamento/{departamentoId}")
    public void updateDepartamento(@PathVariable(value = "edificioId") String edificioId,
                                   @PathVariable(value = "departamentoId") String departamentoId,
                                   @Valid @RequestBody Departamento departamentorequest) {
        if (!edificiorepo.existsById(edificioId)) {
            logger.error("[Error en edificioId: ROUTE: /Departamento .... Method: updateDepartamento]");
            throw new ResourceNotFoundExcption("edificioId " + edificioId + " not found");
        }
        logger.info("[Actualizando Departamento : ROUTE: /Departamento .... Method: updateDepartamento]");
        try {
            logger.info("[Actualizando ..... : ROUTE: /Departamento .... Method: updateDepartamento]");
            departatamentorepo.findById(departamentoId).map(departamento -> {
                departamento.setIdDepto(departamentorequest.getIdDepto());
                departamento.setCantDorm(departamentorequest.getCantDorm());
                departamento.setCantDorm(departamentorequest.getCantDorm());
                departamento.setCantDorm(departamentorequest.getCantDorm());
                departamento.setCantDorm(departamentorequest.getCantDorm());
                logger.info("[Departamento Actualziado ..... : ROUTE: /Departamento .... Method: updateDepartamento]");
                return departatamentorepo.save(departamento);
            }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + departamentoId + "not found"));
        } catch (Exception ex) {
            logger.error("[Error en Actualizacion Departamento: ROUTE: /Departamento .... Method: updateDepartamento]");
            ex.getMessage();
            return;
        }
    }

    //#DELETE METHOD: ELIMINACION DE DEPARTAMENTO
    @DeleteMapping("/edificio/{edificioId}/departamento/{departamentoId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteDepartamento(@PathVariable(value = "edificioId") String edificioId,
                                           @PathVariable(value = "departamentoId") String departamentoId) {
        if (!edificiorepo.existsById(edificioId)) {
            logger.error("[Error en edificioId: ROUTE: /Departamento .... Method: updateDepartamento]");
            throw new ResourceNotFoundExcption("PostId " + edificioId + " not found");
        }
        logger.info("[Eliminando Departamento  ..... : ROUTE: /Departamento .... Method: updateDepartamento]");

        try {
            logger.info("[Eliminando ..... : ROUTE: /Departamento .... Method: updateDepartamento]");

            return departatamentorepo.findById(departamentoId).map(departamento -> {
                departatamentorepo.delete(departamento);
                logger.info("[Departamento Eliminado ..... : ROUTE: /Departamento .... Method: updateDepartamento]");
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + departamentoId + " not found"));

        } catch (Exception ex) {
            logger.error("[Error en Eliminando Departamento: ROUTE: /Departamento .... Method: deleteDepartamento]");
            ex.getMessage();
            return null;
        }
    }
}
