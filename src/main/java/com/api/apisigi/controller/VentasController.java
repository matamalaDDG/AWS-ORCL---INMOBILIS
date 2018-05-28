package com.api.apisigi.controller;

import com.api.apisigi.entity.Venta;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.*;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    //#CORREDOR
    @Autowired
    @Qualifier("corredorRepo")
    private IRCorredor corredorrepo;

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
    @PostMapping("/nuevaventa/conservador/{idconservador}/empresas/convenio/{idcovenio}/banco/tipopago/documentos/{iddocbanco}/notaria/documentos/{iddocnotaria}/externos/venta/servicios/{idservicio}/documentos/venta/tasacion/{idtasacion}/ventas/vendedor/corredor/{idcorredor}")
    @ResponseBody
    @JsonFormat
    public void createVenta(@PathVariable(value = "idconservador") String idconservador,
                            @PathVariable(value = "idcovenio") String idcovenio,
                            @PathVariable(value = "iddocbanco") String iddocbanco,
                            @PathVariable(value = "iddocnotaria") String iddocnotaria,
                            @PathVariable(value = "idservicio") String idservicio,
                            @PathVariable(value = "idtasacion") String idtasacion,
                            @PathVariable(value = "idcorredor") String idcorredor,
                            @Valid @RequestBody Venta venta) {
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

        //#CONSERVADOR
        corredorrepo.findById(idcorredor).map(corredor -> {
            venta.setCorredor(corredor);
            return venta;
        }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idcorredor + " not found"));

        ventarepo.save(venta);
    }


    //#PUT METHOD: ACTUALIZACION DE VENTA
    @PutMapping("/nuevaventa/conservador/{idconservador}/empresas/convenio/{idcovenio}/banco/tipopago/documentos/{iddocbanco}/notaria/documentos/{iddocnotaria}/externos/venta/servicios/{idservicio}/documentos/venta/tasacion/{idtasacion}/ventas/vendedor/corredor/{idcorredor}")
    public Venta updateVenta(@PathVariable(value = "idconservador") String idconservador,
                             @PathVariable(value = "idcovenio") String idcovenio,
                             @PathVariable(value = "iddocbanco") String iddocbanco,
                             @PathVariable(value = "iddocnotaria") String iddocnotaria,
                             @PathVariable(value = "idservicio") String idservicio,
                             @PathVariable(value = "idtasacion") String idtasacion,
                             @PathVariable(value = "idcorredor") String idcorredor,
                             @Valid @RequestBody Venta ventarequest) {
        if (!conservadorrepo.existsById(idconservador) || idconservador != "null" ||
                !conveniorepo.existsById(idcovenio) || idcovenio != "null" ||
                !docbancorepo.existsById(iddocbanco) || iddocbanco != "null" ||
                !conveniorepo.existsById(iddocnotaria) || iddocnotaria != "null" ||
                !corredorrepo.existsById(idtasacion) || idtasacion != "null" ||
                !corredorrepo.existsById(idservicio) || idservicio != "null" ||
                !corredorrepo.existsById(idcorredor) || idcorredor != "null") {
            throw new ResourceNotFoundExcption("ID " + idconservador + "not found," +
                    "ID " + idcovenio + "not found," +
                    "ID " + iddocbanco + "not found," +
                    "ID " + iddocnotaria + "not found," +
                    "ID " + idtasacion + "not found," +
                    "ID " + idservicio + "not found," +
                    "ID " + idcorredor + "not found.");
        }
        return ventarepo.findVentaByConservadorAndConvenioAndDocbancoAndDocnotariaAndServiciosAndTasacionAndCorredor(idconservador, idcovenio, iddocbanco, iddocnotaria, idservicio, idtasacion, idcorredor).map(venta -> {
            venta.setConvenio(ventarequest.getConvenio());
            venta.setCorredor(ventarequest.getCorredor());
            venta.setDocbanco(ventarequest.getDocbanco());
            venta.setTasacion(ventarequest.getTasacion());
            venta.setDocnotaria(ventarequest.getDocnotaria());
            venta.setServicios(ventarequest.getServicios());
            return ventarepo.save(venta);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idconservador + "not found," +
                "ID " + idcovenio + "not found," +
                "ID " + iddocbanco + "not found," +
                "ID " + iddocnotaria + "not found," +
                "ID " + idtasacion + "not found," +
                "ID " + idservicio + "not found," +
                "ID " + idcorredor + "not found."));
    }

    @DeleteMapping("/nuevaventa/conservador/{idconservador}/empresas/convenio/{idcovenio}/banco/tipopago/documentos/{iddocbanco}/notaria/documentos/{iddocnotaria}/externos/venta/servicios/{idservicio}/documentos/venta/tasacion/{idtasacion}/ventas/vendedor/corredor/{idcorredor}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> eliminarCapacidadeconomica(@PathVariable(value = "idconservador") String idconservador,
                                                        @PathVariable(value = "idcovenio") String idcovenio,
                                                        @PathVariable(value = "iddocbanco") String iddocbanco,
                                                        @PathVariable(value = "iddocnotaria") String iddocnotaria,
                                                        @PathVariable(value = "idservicio") String idservicio,
                                                        @PathVariable(value = "idtasacion") String idtasacion,
                                                        @PathVariable(value = "idcorredor") String idcorredor) {
        if (!conservadorrepo.existsById(idconservador) || idconservador != "null" ||
                !conveniorepo.existsById(idcovenio) || idcovenio != "null" ||
                !docbancorepo.existsById(iddocbanco) || iddocbanco != "null" ||
                !conveniorepo.existsById(iddocnotaria) || iddocnotaria != "null" ||
                !corredorrepo.existsById(idtasacion) || idtasacion != "null" ||
                !corredorrepo.existsById(idservicio) || idservicio != "null" ||
                !corredorrepo.existsById(idcorredor) || idcorredor != "null") {
            throw new ResourceNotFoundExcption("ID " + idconservador + "not found," +
                    "ID " + idcovenio + "not found," +
                    "ID " + iddocbanco + "not found," +
                    "ID " + iddocnotaria + "not found," +
                    "ID " + idtasacion + "not found," +
                    "ID " + idservicio + "not found," +
                    "ID " + idcorredor + "not found.");
        }

        return ventarepo.findVentaByConservadorAndConvenioAndDocbancoAndDocnotariaAndServiciosAndTasacionAndCorredor(idconservador, idcovenio, iddocbanco, iddocnotaria, idservicio, idtasacion, idcorredor).map(venta -> {
            ventarepo.delete(venta);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idconservador + "not found," +
                "ID " + idcovenio + "not found," +
                "ID " + iddocbanco + "not found," +
                "ID " + iddocnotaria + "not found," +
                "ID " + idtasacion + "not found," +
                "ID " + idservicio + "not found," +
                "ID " + idcorredor + "not found."));
    }
}


