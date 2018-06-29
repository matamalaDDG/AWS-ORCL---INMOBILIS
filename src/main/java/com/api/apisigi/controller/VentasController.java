package com.api.apisigi.controller;

import com.api.apisigi.entity.Venta;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.*;
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
@RequestMapping("/api/propiedades/transacciones/ventas")
public class VentasController {
    public static final Log logger = LogFactory.getLog(VentasController.class);

    //#VENTAS
    @Autowired
    @Qualifier("ventaRepo")
    private IRVenta ventarepo;
    //#CONSERVADOR
    @Autowired
    @Qualifier("conservadorRepo")
    private IRConservador conservadorrepo;
    //#CONVENIO
    @Autowired
    @Qualifier("convenioRepo")
    private IRConvenio conveniorepo;
    //#DOCBANCO
    @Autowired
    @Qualifier("docbancoRepo")
    private IRDocBanco docbancorepo;
    //#DOCNOTARIA
    @Autowired
    @Qualifier("docNotariaRepo")
    private IRDocNotaria docnotariarepo;
    //#SERVICIOS
    @Autowired
    @Qualifier("servicioRepo")
    private IRServicios serviciosrepo;
    //#TASACION
    @Autowired
    @Qualifier("tasacionRepo")
    private IRTasacion tasacionrepo;

    //#ROUTE METHODS
    //#POST METHOD: INSERCION VENTA
    @GetMapping("/asociados/convenios")
    @ResponseBody
    @JsonFormat
    public List<Venta> listaventas() {
        //TODO Agregar LOGS

        List temp_venta = new ArrayList<>();
        ventarepo.findAll().forEach(temp_venta::add);
        return temp_venta;
        //return regionre.findAll().;
    }

    //#POST METHOD: INSERCION DEPARTAMENTO + IDEDIFICIO
    @PostMapping("/nuevaventa/conservador/{idconservador}/empresas/convenio/{idcovenio}/banco/tipopago/documentos/{iddocbanco}/notaria/documentos/{iddocnotaria}/externos/venta/servicios/{idservicio}/documentos/venta/tasacion/{idtasacion}/ventas/")
    @ResponseBody
    @JsonFormat
    public void createVenta(@PathVariable(value = "idconservador") String idconservador,
                            @PathVariable(value = "idcovenio") String idcovenio,
                            @PathVariable(value = "iddocbanco") String iddocbanco,
                            @PathVariable(value = "iddocnotaria") String iddocnotaria,
                            @PathVariable(value = "idservicio") String idservicio,
                            @PathVariable(value = "idtasacion") String idtasacion,
                            @Valid @RequestBody Venta venta) {
        logger.info("[Creando Venta : ROUTE: /venta .... Method: createVenta]");
        logger.info("[La Venta se esta creando: ROUTE: /venta .... Method: createVenta]");
        try {
            //#CONSERVADOR
            docbancorepo.findById(idconservador).map(conservador -> {
                venta.setDocbanco(conservador);
                return venta;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + iddocbanco + " not found"));
            //#CONVENIO
            docbancorepo.findById(idcovenio).map(convenio -> {
                venta.setDocbanco(convenio);
                return venta;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + iddocbanco + " not found"));

            //#DOCBANCO
            docbancorepo.findById(iddocbanco).map(docBanco -> {
                venta.setDocbanco(docBanco);
                return venta;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + iddocbanco + " not found"));

            //#DOCNOTARIA
            docnotariarepo.findById(iddocnotaria).map(docnotaria -> {
                venta.setDocnotaria(docnotaria);
                return venta;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + iddocnotaria + " not found"));

            //#SERVICIO
            serviciosrepo.findById(idservicio).map(servicio -> {
                venta.setServicios(servicio);
                return venta;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idservicio + " not found"));

            //#TASACION
            tasacionrepo.findById(idtasacion).map(tasacion -> {
                venta.setTasacion(tasacion);
                return venta;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idtasacion + " not found"));
            int random1 = (int) (Math.random() * 999999 - 1);
            int random2 = (int) (Math.random() * 500 - 1);
            String id = "VE" + random2 + "NT-" + random1;
            venta.setIdVenta(id);
            ventarepo.save(venta);
            logger.info("[Venta creada: ROUTE: /venta .... Method: createVenta]");
        } catch (Exception ex) {
            return;
        }

    }


    //#PUT METHOD: ACTUALIZACION DE VENTA
    @PutMapping("/nuevaventa/conservador/{idconservador}/empresas/convenio/{idcovenio}/banco/tipopago/documentos/{iddocbanco}/notaria/documentos/{iddocnotaria}/externos/venta/servicios/{idservicio}/documentos/venta/tasacion/{idtasacion}/ventas")
    public void updateVenta(@PathVariable(value = "idconservador") String idconservador,
                             @PathVariable(value = "idcovenio") String idcovenio,
                             @PathVariable(value = "iddocbanco") String iddocbanco,
                             @PathVariable(value = "iddocnotaria") String iddocnotaria,
                             @PathVariable(value = "idservicio") String idservicio,
                             @PathVariable(value = "idtasacion") String idtasacion,
                             @Valid @RequestBody Venta ventarequest) {
        if (!conservadorrepo.existsById(idconservador) || idconservador != "null" ||
                !conveniorepo.existsById(idcovenio) || idcovenio != "null" ||
                !docbancorepo.existsById(iddocbanco) || iddocbanco != "null" ||
                !conveniorepo.existsById(iddocnotaria) || iddocnotaria != "null" ||
                !tasacionrepo.existsById(idtasacion) || idtasacion != "null" ||
                !serviciosrepo.existsById(idservicio) || idservicio != "null") {
            throw new ResourceNotFoundExcption("ID " + idconservador + "not found," +
                    "ID " + idcovenio + "not found," +
                    "ID " + iddocbanco + "not found," +
                    "ID " + iddocnotaria + "not found," +
                    "ID " + idtasacion + "not found," +
                    "ID " + idservicio + "not found,");
        }
        logger.info("[ACtualizando Venta : ROUTE: /venta .... Method: updateVenta]");
        logger.info("[La Venta se esta ACtualizando: ROUTE: /venta .... Method: updateVenta]");
        try {
             ventarepo.findVentaByConservadorAndConvenioAndDocbancoAndDocnotariaAndServiciosAndTasacion(idconservador, idcovenio, iddocbanco, iddocnotaria, idservicio, idtasacion).map(venta -> {
                venta.setConvenio(ventarequest.getConvenio());
                venta.setDocbanco(ventarequest.getDocbanco());
                venta.setTasacion(ventarequest.getTasacion());
                venta.setDocnotaria(ventarequest.getDocnotaria());
                venta.setServicios(ventarequest.getServicios());
                logger.info("[La Venta se a Actualizando: ROUTE: /venta .... Method: updateVenta]");
                return ventarepo.save(venta);
            }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idconservador + "not found," +
                    "ID " + idcovenio + "not found," +
                    "ID " + iddocbanco + "not found," +
                    "ID " + iddocnotaria + "not found," +
                    "ID " + idtasacion + "not found," +
                    "ID " + idservicio + "not found,"));
        } catch (Exception ex) {
            logger.error("[Ocurrio un error en la actualizacion: ROUTE: /venta .... Method: updateVenta]");
            return ;
        }
    }

    @DeleteMapping("/nuevaventa/conservador/{idconservador}/empresas/convenio/{idcovenio}/banco/tipopago/documentos/{iddocbanco}/notaria/documentos/{iddocnotaria}/externos/venta/servicios/{idservicio}/documentos/venta/tasacion/{idtasacion}/ventas/vendedor/")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteVenta(@PathVariable(value = "idconservador") String idconservador,
                                         @PathVariable(value = "idcovenio") String idcovenio,
                                         @PathVariable(value = "iddocbanco") String iddocbanco,
                                         @PathVariable(value = "iddocnotaria") String iddocnotaria,
                                         @PathVariable(value = "idservicio") String idservicio,
                                         @PathVariable(value = "idtasacion") String idtasacion) {
        if (!conservadorrepo.existsById(idconservador) || idconservador != "null" ||
                !conveniorepo.existsById(idcovenio) || idcovenio != "null" ||
                !docbancorepo.existsById(iddocbanco) || iddocbanco != "null" ||
                !conveniorepo.existsById(iddocnotaria) || iddocnotaria != "null" ||
                !tasacionrepo.existsById(idtasacion) || idtasacion != "null" ||
                !serviciosrepo.existsById(idservicio) || idservicio != "null") {
            throw new ResourceNotFoundExcption("ID " + idconservador + "not found," +
                    "ID " + idcovenio + "not found," +
                    "ID " + iddocbanco + "not found," +
                    "ID " + iddocnotaria + "not found," +
                    "ID " + idtasacion + "not found," +
                    "ID " + idservicio + "not found,");
        }
        logger.info("[La Venta se Eliminara: ROUTE: /venta .... Method: updateVenta]");
        logger.info("[Eliminando...... : ROUTE: /venta .... Method: updateVenta]");
        try {
            return ventarepo.findVentaByConservadorAndConvenioAndDocbancoAndDocnotariaAndServiciosAndTasacion(idconservador, idcovenio, iddocbanco, iddocnotaria, idservicio, idtasacion).map(venta -> {
                logger.info("[La Venta se a Eliminado: ROUTE: /venta .... Method: updateVenta]");
                ventarepo.delete(venta);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idconservador + "not found," +
                    "ID " + idcovenio + "not found," +
                    "ID " + iddocbanco + "not found," +
                    "ID " + iddocnotaria + "not found," +
                    "ID " + idtasacion + "not found," +
                    "ID " + idservicio + "not found,"));
        } catch (Exception ex) {
            logger.error("[Ocurrio un error en la eliminacion: ROUTE: /venta .... Method: updateVenta]");
            return null;
        }
    }
}


