package com.api.apisigi.controller;

import com.api.apisigi.entity.Convenio;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRConvenio;
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
@RequestMapping("/api/ventas/empresas/convenio")
public class ConvenioController {
    public static final Log logger = LogFactory.getLog(ConvenioController.class);

    @Autowired
    @Qualifier("convenioRepo")
    private IRConvenio conveniorepo;

    @Autowired
    @Qualifier("empresasRepo")
    private IREmpresas empresasrepo;

    //#REQUEST METHODS
    //#GET METHOD: LISTADO REGION
    @GetMapping("/asociados/convenios")
    @ResponseBody
    @JsonFormat
    public List<Convenio> listarConvenios() {
        //TODO Agregar LOGS
        logger.info("[Listando Convenio : ROUTE: /regiones .... Method: listarConvenios]");
        try {
            logger.info("[ Convenio Listado : ROUTE: /regiones .... Method: listarConvenios]");
            List temp_convenios = new ArrayList();
            conveniorepo.findAll().forEach(temp_convenios::add);
            return temp_convenios;
            //return regionre.findAll().;
        } catch (Exception ex) {
            logger.error("[Error Listando Convenio : ROUTE: /Convenio .... Method: listarConvenios]");
            ex.getMessage();
            return null;
        }
    }


    //#POST METHOD: INSERCION REGION
    @PostMapping("/asociados/empresas/{idempresa}/conveino/nuevo")
    @ResponseBody
    @JsonFormat
    public void createConvenio(@PathVariable(value = "idempresa") String idempresa,
                               @Valid @RequestBody Convenio convenio) {
        logger.info("[Creando Convenio : ROUTE: /regiones .... Method: createConvenio]");
        try {
            logger.info("[Se esta Creando el Convenio : ROUTE: /regiones .... Method: createConvenio]");
            empresasrepo.findById(idempresa).map((empresa) -> {
                convenio.setEmpresa(empresa);
                return convenio;
            }).orElseThrow(() -> new ResourceNotFoundExcption("idempresa " + idempresa + " not found"));
            logger.info("[Convenio  creado: ROUTE: /Convenio .... Method: createConvenio]");
            conveniorepo.save(convenio);
        } catch (Exception ex) {
            logger.error("[Error Listando Convenio : ROUTE: /Convenio .... Method: createConvenio]");
            return;
        }
    }

    //#PUT METHOD: ELIMINAR CONVENIO
    @DeleteMapping("/asociados/empresas/{idempresa}/conveino/{idconvenio}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> eliminarConvenio(@PathVariable(value = "idempresa") String idempresa,
                                              @PathVariable(value = "idconvenio") String idconvenio) {
        if (!empresasrepo.existsById(idempresa)) {
            logger.info("[Empresa no existe : ROUTE: /convenio .... Method: eliminarConvenio]");
            throw new ResourceNotFoundExcption("idempresa " + idempresa + " not found");
        }
        logger.info("[Creando Convenio : ROUTE: /convenio .... Method: eliminarConvenio]");

        try {
            logger.info("[Se esta Creando Convenio : ROUTE: /convenio .... Method: eliminarConvenio]");

            return conveniorepo.findById(idconvenio).map(convenio -> {
                logger.info("[Convenio Creado  : ROUTE: /convenio .... Method: eliminarConvenio]");
                conveniorepo.delete(convenio);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("idconvenio " + idconvenio + " not found"));

        } catch (Exception ex) {
            logger.error("[Error Creando Convenio : ROUTE: /convenio .... Method: eliminarConvenio]");
                ex.getMessage();
            return null;
        }
    }

    //#UPDATE REGION
    @PutMapping("/asociados/empresas/{idempresa}/conveino/{idconvenio}/eliminar")
    @ResponseBody
    @JsonFormat
    public void updateConvenio(@PathVariable(value = "idempresa") String idempresa,
                             @PathVariable(value = "idconvenio") String idconvenio,
                             @Valid @RequestBody Convenio conveniorequest) {
        if (!empresasrepo.existsById(idempresa)) {
            logger.info("[Empresa no existe : ROUTE: /convenio .... Method: updateConvenio]");
            throw new ResourceNotFoundExcption("idempresa " + idempresa + " not found");
        }
        logger.info("[Actualizando Convenio : ROUTE: /convenio .... Method: updateConvenio]");
        try {
            logger.info("[Realizando modificacion Convenio : ROUTE: /convenio .... Method: updateConvenio]");
            conveniorepo.findById(idconvenio).map(convenio -> {
                convenio.setDscto(conveniorequest.getDscto());
                convenio.setDescripcion(conveniorequest.getDescripcion());
                convenio.setTipoConvenio(conveniorequest.getTipoConvenio());
                logger.info("[Modificacion en convenio Realizando : ROUTE: /convenio .... Method: updateConvenio]");
                return conveniorepo.save(convenio);
            }).orElseThrow(() -> new ResourceNotFoundExcption("idconvenio " + idconvenio + "not found"));
        } catch (Exception ex) {
            logger.info("[Error al modificar Convenio : ROUTE: /convenio .... Method: updateConvenio]");
                ex.getMessage();
            return;
        }


    }
}
