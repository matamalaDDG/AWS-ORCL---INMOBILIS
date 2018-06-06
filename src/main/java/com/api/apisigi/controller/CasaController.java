package com.api.apisigi.controller;

import com.api.apisigi.entity.Casa;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRCasa;
import com.api.apisigi.repository.IRCondominio;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/tipo/casa")
public class CasaController {

    @Autowired
    @Qualifier("casaRepo")
    private IRCasa casarepo;

    @Autowired
    @Qualifier("condominioRepo")
    private IRCondominio condominiorepo;

    //    POST MAPPING:
    @PostMapping("/condominio/{condomionioId}/nCasa")
    @ResponseBody
    @JsonFormat
    public Casa createCasa(@PathVariable(value = "condomionioId") String condomionioId,
                           @Valid @RequestBody Casa casa) {
        return casarepo.save(
                condominiorepo.findById(condomionioId).map(condominio -> {
                    casa.setCondominio(condominio);
                    return casa;
                }).orElseThrow(() -> new ResourceNotFoundExcption("condomionioId " + condomionioId + " not found")
                ));
    }

    //    GET MAPPING:
    @GetMapping("/casas")
    @ResponseBody
    @JsonFormat
    public List<Casa> getAll() {
        return casarepo.findAll();
    }

    //TODO
    //    GET MAPPING: ById
    //    GET MAPPING: findByIdCasa
    //    GET MAPPING: findAllByIdCondominio

    //    PUT MAPPING:
    @PutMapping("/condominio/{condominioId}/casa/{casaid}")
    public Casa updateCasa(@PathVariable(value = "condominioId") String condominioId,
                           @PathVariable(value = "casaid") String casaid,
                           @Valid @RequestBody Casa casaRequest) {
        if (!condominiorepo.existsById(condominioId)) {
            throw new ResourceNotFoundExcption("ID " + condominioId + " not found");
        }

        return casarepo.findById(casaid).map(casa -> {
            casa.setIdCasa(casaRequest.getIdCasa());
            casa.setCantBanos(casaRequest.getCantBanos());
            casa.setCantDorm(casaRequest.getCantDorm());
            casa.setMtsHabConst(casaRequest.getMtsHabConst());
            casa.setMtsPatConst(casaRequest.getMtsPatConst());
            return casarepo.save(casa);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + casaid + "not found"));
    }

    //    DELETE MAPPING:
    @DeleteMapping("/condominio/{condominioId}/casa/{casaid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteComment(@PathVariable(value = "condominioId") String condominioId,
                                           @PathVariable(value = "casaid") String casaid) {
        if (!condominiorepo.existsById(condominioId)) {
            throw new ResourceNotFoundExcption("ID " + condominioId + " not found");
        }

        return casarepo.findById(casaid).map(casa -> {
            casarepo.delete(casa);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + casaid + " not found"));
    }
}
