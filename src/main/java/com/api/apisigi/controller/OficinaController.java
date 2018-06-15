package com.api.apisigi.controller;

import com.api.apisigi.entity.Oficina;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IROficina;
import com.api.apisigi.repository.IRPatenteComercial;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController("/api/propiedad/tipo/")
public class OficinaController {

    @Autowired
    @Qualifier("oficinaRepo")
    private IROficina oficinarepo;
    @Autowired
    @Qualifier("patenteComercialRepo")
    private IRPatenteComercial patenterepo;

    //#LISTADO DE COMUNA
    @GetMapping("/oficinas")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @JsonFormat
    public List<Oficina> getAll() {
        return oficinarepo.findAll();
    }

    //#AGREGAR COMUNAS NUEVAS CON RELACION DE REGION
    @PostMapping("/oficina/{idpatente}/noficina")
    @ResponseBody
    @JsonFormat
    public void createComuna(@PathVariable(value = "idpatente") String idpatente,
                             @Valid @RequestBody Oficina oficina) {
        patenterepo.findById(idpatente).map((patente) -> {
            //TODO Agregar LOGS
            oficina.setPatenteComercial(patente);
            oficinarepo.save(oficina);
            return oficina;
        }).orElseThrow(() -> new ResourceNotFoundExcption("idpatente " + idpatente + " not found"));
    }

    //    PUT MAPPING:
    //# PUTCONTROLLER
    @PutMapping("/patente/{patenteid}/oficina/{oficinaid}")
    @ResponseBody
    @JsonFormat
    public Oficina updateComuna(@PathVariable(value = "patenteid") String patenteid,
                                @PathVariable(value = "oficinaid") String oficinaid,
                                @Valid @RequestBody Oficina oficinaRequest) {

        if (!patenterepo.existsById(patenteid)) {
            throw new ResourceNotFoundExcption("patenteid " + patenteid + " not found");
        }

        return oficinarepo.findById(oficinaid).map(oficina -> {
            oficina.setMtsCuadDisp(oficinaRequest.getMtsCuadDisp());
            oficina.setNumOficina(oficinaRequest.getNumOficina());

            return oficinarepo.save(oficina);
        }).orElseThrow(() -> new ResourceNotFoundExcption("oficinaid " + oficinaid + "not found"));
    }

    //    DELETE MAPPING:
    //# ELIMINAR UNA COMUNA
    @DeleteMapping("/patente/{patenteid}/oficina/{oficinaid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteComment(@PathVariable(value = "patenteid") String patenteid,
                                           @PathVariable(value = "oficinaid") String oficinaid) {
        if (!patenterepo.existsById(patenteid)) {
            throw new ResourceNotFoundExcption("patenteid " + patenteid + " not found");
        }
        return oficinarepo.findById(oficinaid).map(comuna -> {
            oficinarepo.delete(comuna);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + oficinaid + " not found"));
    }

}
