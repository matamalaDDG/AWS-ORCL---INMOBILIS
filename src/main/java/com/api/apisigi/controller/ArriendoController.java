package com.api.apisigi.controller;

import com.api.apisigi.entity.Arriendo;
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
@RequestMapping("/api/propiedades/estado/proceso/arriendo")
public class ArriendoController {

    @Autowired
    @Qualifier("arriendoRepo")
    private IRArriendo arriendorepo;

    @Autowired
    @Qualifier("capacidadEconomicaRepo")
    private IRCapacidadEconomica capacidadEconomicarepo;

    @Autowired
    @Qualifier("corredorRepo")
    private IRCorredor corredorrepo;

    @Autowired
    @Qualifier("convenioRepo")
    private IRConvenio conveniorepo;

    @Autowired
    @Qualifier("aseguradoraRepo")
    private IRAseguradora aseguradorarepo;

    @Autowired
    @Qualifier("precontratoRepo")
    private IRPrecontrato precontratorepo;

    //#GET METHOD: LISTADO REGION
    @GetMapping("/asociados/convenios")
    @ResponseBody
    @JsonFormat
    public List<Arriendo> litarArriendo() {
        //TODO Agregar LOGS

        List temp_arriendo = new ArrayList();
        capacidadEconomicarepo.findAll().forEach(temp_arriendo::add);
        return temp_arriendo;
        //return regionre.findAll().;
    }

    //#POST METHOD: INSERCION CONVENIO
    @PostMapping("/arriendo/contrato/precontrato/{precontratoid}/seguro/aseguradora/poliza/{aseguradoraid}/capacidad/costos/{capacidadeconomicaid}/empresas/convenio/{convenioid}/empresa/corredores/{corredorid}/nuevoarriendo")
    @ResponseBody
    @JsonFormat
    public void createCapacidadEconomica(@PathVariable(value = "precontratoid") String precontratoid,
                                         @PathVariable(value = "aseguradoraid") String aseguradoraid,
                                         @PathVariable(value = "capacidadeconomicaid") String capacidadeconomicaid,
                                         @PathVariable(value = "convenioid") String convenioid,
                                         @PathVariable(value = "corredorid") String corredorid,
                                         @Valid @RequestBody Arriendo arriendo) {
        //precontrato
        precontratorepo.findById(precontratoid).map((precontrato) -> {
            arriendo.setPrecontrato(precontrato);
            return arriendo;
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID" + precontratoid + " not found"));
        //aseguradora
        aseguradorarepo.findById(aseguradoraid).map((aseguradora) -> {
            arriendo.setAseguradora(aseguradora);
            return arriendo;
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID" + aseguradoraid + " not found"));
        //capacidadeconomica
        capacidadEconomicarepo.findById(capacidadeconomicaid).map((capacidadEconomica) -> {
            arriendo.setCapacidadeconomica(capacidadEconomica);
            return arriendo;
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + capacidadeconomicaid + " not found"));
        //convenio
        conveniorepo.findById(convenioid).map((convenio) -> {
            arriendo.setConvenio(convenio);
            return arriendo;
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID" + convenioid + " not found"));
        //corredor
        corredorrepo.findById(corredorid).map((corredor) -> {
            arriendo.setCorredor(corredor);
            return arriendo;
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID" + corredorid + " not found"));
        arriendorepo.save(arriendo); //AGREGAMOS TODOS LOS DATOS
    }

    //#PUT METHOD: ELIMINAR CONVENIO
    @PutMapping("/arriendo/contrato/precontrato/{precontratoid}/seguro/aseguradora/poliza/{aseguradoraid}/capacidad/costos/{capacidadeconomicaid}/empresas/convenio/{convenioid}/empresa/corredores/{corredorid}/nuevoarriendo")
    @ResponseBody
    @JsonFormat
    public Arriendo actualizarArriendo(@PathVariable(value = "precontratoid") String precontratoid,
                                       @PathVariable(value = "aseguradoraid") String aseguradoraid,
                                       @PathVariable(value = "capacidadeconomicaid") String capacidadeconomicaid,
                                       @PathVariable(value = "convenioid") String convenioid,
                                       @PathVariable(value = "corredorid") String corredorid,
                                       @Valid @RequestBody Arriendo arriendorequest) {

        if (!precontratorepo.existsById(precontratoid) || precontratoid != "null" ||
                !aseguradorarepo.existsById(aseguradoraid) || aseguradoraid != "null" ||
                !capacidadEconomicarepo.existsById(capacidadeconomicaid) || capacidadeconomicaid != "null" ||
                !conveniorepo.existsById(convenioid) || convenioid != "null" ||
                !corredorrepo.existsById(corredorid) || corredorid != "null") {
            throw new ResourceNotFoundExcption("ID " + precontratoid + "not found," +
                    "ID " + aseguradoraid + "not found" +
                    "ID " + capacidadeconomicaid + "not found" +
                    "ID " + convenioid + "not found" +
                    "ID " + corredorid + "not found");
        }
        return arriendorepo.findArriendoByAseguradoraAndPrecontratoAndCapacidadeconomicaAndConvenioAndCorredor(precontratoid, aseguradoraid, capacidadeconomicaid, convenioid, corredorid).map(arriendo -> {
            arriendo.setNotificacion(arriendorequest.getNotificacion());
            arriendo.setFechaArriendo(arriendorequest.getFechaArriendo());
            arriendo.setMonto(arriendorequest.getMonto());
            return arriendorepo.save(arriendo);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + precontratoid + "not found," +
                "ID " + aseguradoraid + "not found" +
                "ID " + capacidadeconomicaid + "not found" +
                "ID " + convenioid + "not found" +
                "ID " + corredorid + "not found"));
    }

    //TODO REVISION Y CORRECCION DE METODO DELETE
    //#DELETE METHOD: ELIMINAR CONVENIO
    @DeleteMapping("/cliente/{cedulaid}/ingresos/{liquidacionid}/honorarios/{boletaHonorarioId}/documentacion/{contratioid}/arriendo/{arriendoid}/cliente/capacidadecomicalciente/{idCapacidad}/eliminar")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> eliminarCapacidadeconomica(@PathVariable(value = "precontratoid") String precontratoid,
                                                        @PathVariable(value = "aseguradoraid") String aseguradoraid,
                                                        @PathVariable(value = "capacidadeconomicaid") String capacidadeconomicaid,
                                                        @PathVariable(value = "convenioid") String convenioid,
                                                        @PathVariable(value = "corredorid") String corredorid,
                                                        @PathVariable(value = "arriendoid") String arriendoid) {
        if (!precontratorepo.existsById(precontratoid) || precontratoid != "null" ||
                !aseguradorarepo.existsById(aseguradoraid) || aseguradoraid != "null" ||
                !capacidadEconomicarepo.existsById(capacidadeconomicaid) || capacidadeconomicaid != "null" ||
                !conveniorepo.existsById(convenioid) || convenioid != "null" ||
                !corredorrepo.existsById(corredorid) || corredorid != "null"||
                !arriendorepo.existsById(arriendoid) ) {
            throw new ResourceNotFoundExcption("ID " + precontratoid + "not found," +
                    "ID " + aseguradoraid + "not found" +
                    "ID " + capacidadeconomicaid + "not found" +
                    "ID " + convenioid + "not found" +
                    "ID " + corredorid + "not found" +
                    "ID " + arriendoid + "not found");
        }

        return arriendorepo.findArriendoByAseguradoraAndPrecontratoAndCapacidadeconomicaAndConvenioAndCorredor(precontratoid, aseguradoraid, capacidadeconomicaid, convenioid, corredorid).map(arriendo -> {
            arriendorepo.delete(arriendo);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + precontratoid + "not found," +
                "ID " + aseguradoraid + "not found" +
                "ID " + capacidadeconomicaid + "not found" +
                "ID " + convenioid + "not found" +
                "ID " + corredorid + "not found"));
    }
}

