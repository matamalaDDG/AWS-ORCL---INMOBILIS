package com.api.apisigi.controller;

import com.api.apisigi.entity.CapacidadEconomica;
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
@RequestMapping("/api/propiedades/arriendo/documentacion/capacidadeconomica")
public class CapacidadEconomicaController {

    @Autowired
    @Qualifier("capacidadEconomicaRepo")
    private IRCapacidadEconomica capacidadEconomicarepo;

    @Autowired
    @Qualifier("boletahonorarioRepo")
    private IRBoletaHonorario boletaHonorariorepo;

    @Autowired
    @Qualifier("cedulaIdentidadRepo")
    private IRCedulaIdentidad cedulaIdentidadrepo;

    @Autowired
    @Qualifier("contratoRepo")
    private IRContrato contratorepo;

    @Autowired
    @Qualifier("liquidacionSueldoRepo")
    private IRLiquidacionSueldo liquidacionSueldorepo;

    //#REQUEST METHODS
    //#GET METHOD: LISTADO REGION
    @GetMapping("/asociados/convenios")
    @ResponseBody
    @JsonFormat
    public List<CapacidadEconomica> listaCapacidad() {
        //TODO Agregar LOGS
        List temp_capacidadrepo = new ArrayList();
        capacidadEconomicarepo.findAll().forEach(temp_capacidadrepo::add);
        return temp_capacidadrepo;
        //return regionre.findAll();
    }

    //#POST METHOD: INSERCION CONVENIO
    @PostMapping("/cliente/{cedulaid}" +
            "/ingresos/{liquidacionid}" +
            "/honorarios/{boletaHonorarioId}" +
            "/documentacion/{contratioid}" +
            "/arriendo/cliente/capacidadecomicalciente")
    @ResponseBody
    @JsonFormat
    public void createCapacidadEconomica(@PathVariable(value = "cedulaid") String cedulaid,
                                         @PathVariable(value = "liquidacionid") String liquidacionid,
                                         @PathVariable(value = "boletaHonorarioId") String boletaHonorarioId,
                                         @PathVariable(value = "contratioid") String contratioid,
                                         @Valid @RequestBody CapacidadEconomica capacidadEconomica) {
        cedulaIdentidadrepo.findById(cedulaid).map((cedulaIdentidad) -> {
            capacidadEconomica.setCedulaidentidad(cedulaIdentidad);
            return capacidadEconomica;
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + cedulaid + " not found"));
        liquidacionSueldorepo.findById(liquidacionid).map((empresa) -> {
            capacidadEconomica.setLiquidacionsueldo(empresa);
            return capacidadEconomica;
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + liquidacionid + " not found"));
        boletaHonorariorepo.findById(boletaHonorarioId).map((empresa) -> {
            capacidadEconomica.setBoletahonorario(empresa);
            return capacidadEconomica;
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + boletaHonorarioId + " not found"));
        contratorepo.findById(contratioid).map((empresa) -> {
            capacidadEconomica.setContrato(empresa);
            return capacidadEconomica;
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID  " + contratioid + " not found"));
        capacidadEconomicarepo.save(capacidadEconomica);
    }

    //#PUT METHOD: MODIFICAR CONVENIO
    @PutMapping("/cliente/{cedulaid}/ingresos/{liquidacionid}/honorarios/{boletaHonorarioId}/documentacion/{contratioid}/arriendo/cliente/capacidadecomicalciente/actualizar")
    @ResponseBody
    @JsonFormat
    public CapacidadEconomica actualizarCapacidadEconomica(@PathVariable(value = "cedulaid") String cedulaid,
                                                           @PathVariable(value = "liquidacionid") String liquidacionid,
                                                           @PathVariable(value = "boletaHonorarioId") String boletaHonorarioId,
                                                           @PathVariable(value = "contratioid") String contratioid,
                                                           @Valid @RequestBody CapacidadEconomica capacidadEconomicarequest) {

        if (!contratorepo.existsById(contratioid) || contratioid != "null" ||
                !liquidacionSueldorepo.existsById(liquidacionid) || liquidacionid != "null" ||
                !boletaHonorariorepo.existsById(boletaHonorarioId) || boletaHonorarioId != "null" ||
                !contratorepo.existsById(cedulaid) || cedulaid != "null") {
            throw new ResourceNotFoundExcption("ID " + boletaHonorarioId + "not found," +
                    "ID " + contratioid + "not found" +
                    "ID " + liquidacionid + "not found" +
                    "ID " + cedulaid + "not found");
        }
        return capacidadEconomicarepo.findCapacidadEconomicaByBoletahonorarioAndAndCedulaidentidadAndContratoAndLiquidacionsueldo(cedulaid, liquidacionid, boletaHonorarioId, contratioid).map(capacidadEconomica -> {
            capacidadEconomica.setAval(capacidadEconomicarequest.getAval());
            return capacidadEconomicarepo.save(capacidadEconomica);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + boletaHonorarioId + "not found," +
                "ID " + contratioid + "not found" +
                "ID " + liquidacionid + "not found" +
                "ID " + cedulaid + "not found"));
    }

    //TODO corregir metodo delete, probar
    //#DELETE METHOD: ELIMINAR CONVENIO
    @DeleteMapping("/cliente/{cedulaid}/ingresos/{liquidacionid}/honorarios/{boletaHonorarioId}/documentacion/{contratioid}/arriendo/cliente/capacidadecomicalciente/{idCapacidad}/actualizar")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> eliminarCapacidadeconomica(@PathVariable(value = "cedulaid") String cedulaid,
                                                        @PathVariable(value = "liquidacionid") String liquidacionid,
                                                        @PathVariable(value = "boletaHonorarioId") String boletaHonorarioId,
                                                        @PathVariable(value = "contratioid") String contratioid) {
        if (!contratorepo.existsById(contratioid) || contratioid != "null" ||
                !liquidacionSueldorepo.existsById(liquidacionid) || liquidacionid != "null" ||
                !boletaHonorariorepo.existsById(boletaHonorarioId) || boletaHonorarioId != "null" ||
                !contratorepo.existsById(cedulaid) || cedulaid != "null") {
            throw new ResourceNotFoundExcption("ID " + boletaHonorarioId + "not found," +
                    "ID " + contratioid + "not found" +
                    "ID " + liquidacionid + "not found" +
                    "ID " + cedulaid + "not found");
        }

        return capacidadEconomicarepo.findCapacidadEconomicaByBoletahonorarioAndAndCedulaidentidadAndContratoAndLiquidacionsueldo(cedulaid, liquidacionid, boletaHonorarioId, contratioid).map(capacidadEconomica -> {
            capacidadEconomicarepo.delete(capacidadEconomica);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + boletaHonorarioId + "not found," +
                "ID " + contratioid + "not found" +
                "ID " + liquidacionid + "not found" +
                "ID " + cedulaid + "not found"));
    }
}
