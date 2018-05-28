package com.api.apisigi.controller;

import com.api.apisigi.entity.Convenio;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRConvenio;
import com.api.apisigi.repository.IREmpresas;
import com.fasterxml.jackson.annotation.JsonFormat;
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

        List temp_convenios = new ArrayList();
        conveniorepo.findAll().forEach(temp_convenios::add);
        return temp_convenios;
        //return regionre.findAll().;
    }

    //#POST METHOD: INSERCION REGION
    @PostMapping("/asociados/empresas/{idempresa}/conveino/nuevo")
    @ResponseBody
    @JsonFormat
    public void createComuna(@PathVariable(value = "idempresa") String idempresa,
                             @Valid @RequestBody Convenio convenio) {

        empresasrepo.findById(idempresa).map((empresa) -> {
            convenio.setEmpresa(empresa);
            return convenio;
        }).orElseThrow(() -> new ResourceNotFoundExcption("REGIONID " + idempresa + " not found"));
        conveniorepo.delete(convenio);
    }

    //#PUT METHOD: ELIMINAR CONVENIO
    @DeleteMapping("/asociados/empresas/{idempresa}/conveino/{idconvenio}/acualizar")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> eliminarConvenio(@PathVariable(value = "idcuenta") String idempresa,
                                              @PathVariable(value = "idperfil") String idconvenio) {
        if (!empresasrepo.existsById(idempresa)) {
            throw new ResourceNotFoundExcption("PostId " + idempresa + " not found");
        }

        return conveniorepo.findById(idconvenio).map(convenio -> {
            conveniorepo.delete(convenio);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + idconvenio + " not found"));
    }

    //#UPDATE REGION
    @PutMapping("/asociados/empresas/{idempresa}/conveino/{idconvenio}/eliminar")
    @ResponseBody
    @JsonFormat
    public Convenio updateComuna(@PathVariable(value = "idempresa") String idempresa,
                                 @PathVariable(value = "idconvenio") String idconvenio,
                                 @Valid @RequestBody Convenio conveniorequest) {
        if (!empresasrepo.existsById(idempresa)) {
            throw new ResourceNotFoundExcption("ID " + idempresa + " not found");
        }

        return conveniorepo.findById(idconvenio).map(convenio -> {
            convenio.setDscto(conveniorequest.getDscto());
            convenio.setDescripcion(conveniorequest.getDescripcion());
            convenio.setTipoConvenio(conveniorequest.getTipoConvenio());
            return conveniorepo.save(convenio);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idconvenio + "not found"));
    }
}
