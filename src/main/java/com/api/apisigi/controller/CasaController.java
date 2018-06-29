package com.api.apisigi.controller;

import com.api.apisigi.entity.Casa;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRCasa;
import com.api.apisigi.repository.IRCondominio;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/propiedades/tipo/casa")
public class CasaController {
    public static final Log logger = LogFactory.getLog(CasaController.class);
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
    public void createCasa(@PathVariable(value = "condomionioId") String condomionioId,
                           @Valid @RequestBody Casa casa) {
        logger.info("[Creando Casa : ROUTE: /Casa .... Method: createCasa]");

        try {
            logger.info("[Creando.... : ROUTE: /Casa .... Method: createCasa]");

            casarepo.save(
                    condominiorepo.findById(condomionioId).map(condominio -> {
                        casa.setCondominio(condominio);
                        logger.info("[Casa creada : ROUTE: /Casa .... Method: createCasa]");
                        return casa;
                    }).orElseThrow(() -> new ResourceNotFoundExcption("condomionioId " + condomionioId + " not found")
                    ));
        } catch (Exception ex) {
            logger.error("[Error creando Casa : ROUTE: /Casa.... Method: createCasa]");
            ex.getMessage();
            return;
        }
    }

    //TODO
    //    GET MAPPING: ALL
    //#LISTADO DE COMUNAS
    @GetMapping("/comunas")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @JsonFormat
    public List<Casa> getAllCasas() {
        logger.info("[Buscando Casa : ROUTE: /Casa .... Method: getAllCasas]");
        try {
            logger.info("[Listando Casa : ROUTE: /Casa .... Method: getAllCasas]");
            logger.info("[Casa Listadas : ROUTE: /Casa.... Method: getAllCasas]");
            List temp_casa = new ArrayList<>();
            casarepo.findAll().forEach(temp_casa::add);
            return temp_casa;
        } catch (Exception ex) {
            logger.error("[Error Casas Listadas : ROUTE: /Casa.... Method: getAllCasas]" + ex.getMessage());
            return null;
        }
    }

    //    PUT MAPPING:
    @PutMapping("/condominio/{condominioId}/casa/{casaid}")
    public void updateCasa(@PathVariable(value = "condominioId") String condominioId,
                           @PathVariable(value = "casaid") String casaid,
                           @Valid @RequestBody Casa casaRequest) {
        if (!condominiorepo.existsById(condominioId)) {
            logger.error("[no existe condominio : ROUTE: /Casa.... Method: updateCasa]");
            throw new ResourceNotFoundExcption("condominioId " + condominioId + " not found");
        }
        logger.info("[Actualizado casa : ROUTE: /Casa .... Method: updateCasa]");

        try {
            logger.info("[Actualizado .... : ROUTE: /Casa .... Method: updateCasa]");

            casarepo.findById(casaid).map(casa -> {
                casa.setIdCasa(casaRequest.getIdCasa());
                casa.setCantBanos(casaRequest.getCantBanos());
                casa.setCantDorm(casaRequest.getCantDorm());
                casa.setMtsHabConst(casaRequest.getMtsHabConst());
                casa.setMtsPatConst(casaRequest.getMtsPatConst());
                logger.info("[Casa Actualizada .... : ROUTE: /Casa .... Method: updateCasa]");
                return casarepo.save(casa);
            }).orElseThrow(() -> new ResourceNotFoundExcption("Casa " + casaid + "not found"));
        } catch (Exception ex) {
            logger.error("[Error Regiones Listadas : ROUTE: /regiones.... Method: updateCasa]" + ex.getMessage());
            logger.error(ex.getMessage());
            return;
        }
    }

    //    DELETE MAPPING:
    @DeleteMapping("/condominio/{condominioId}/casa/{casaid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteCasa(@PathVariable(value = "condominioId") String condominioId,
                                        @PathVariable(value = "casaid") String casaid) {
        if (!condominiorepo.existsById(condominioId)) {
            logger.error("[no existe condominio : ROUTE: /Casa.... Method: deleteCasa]");
            throw new ResourceNotFoundExcption("ID " + condominioId + " not found");
        }
        logger.info("[Eliminando Casa .... : ROUTE: /Casa .... Method: updateCasa]");

        try {
            logger.info("[Eliminando .... : ROUTE: /Casa .... Method: updateCasa]");
            return casarepo.findById(casaid).map(casa -> {
                casarepo.delete(casa);
                logger.info("[Casa Eliminada .... : ROUTE: /Casa .... Method: updateCasa]");
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("casaid " + casaid + " not found"));
        } catch (Exception ex) {

            return null;
        }
    }
}
