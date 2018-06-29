package com.api.apisigi.controller;

import com.api.apisigi.entity.CedulaIdentidad;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRCedulaIdentidad;
import com.api.apisigi.repository.IRDocumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propiedad/cliente/")
public class CedulaIdentidadController {
    //#LOGS
    public static final Log logger = LogFactory.getLog(RegionController.class);

    @Autowired
    @Qualifier("cedulaIdentidadRepo")
    private IRCedulaIdentidad cedulaidentidadrepo;

    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;


    //    GET MAPPING:
    @GetMapping("/cedulaidentidad")
    @ResponseBody
    @JsonFormat
    public List<CedulaIdentidad> getAllCedulaIdentidad() {
        return cedulaidentidadrepo.findAll();
    }

    //    POST MAPPING:
    @PostMapping("/documento/{documentoId}/cedulaidentidad/NCedulaIdentidad")
    @ResponseBody
    @JsonFormat
    public void crearCedulaIdentidad(@PathVariable(value = "documentoId") String documentoId,
                                                @Valid @RequestBody CedulaIdentidad cedulaIdentidad) {
        try {
             cedulaidentidadrepo.save(
                    documentorepo.findById(documentoId).map(documento -> {
                        cedulaIdentidad.setDocumento(documento);
                        int random = (int) (Math.random() * 999999 + 1);
                        String id = "CDI" + random;
                        cedulaIdentidad.setIdCedula(id);
                        return cedulaIdentidad;
                    }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + documentoId + " not found")));
        } catch (Exception ex) {
            return ;
        }

    }

    //    PUT MAPPING:
    @PutMapping("/documento/{documentoId}/cedulaIdentidad/{cedulaIdentidadId}")
    @ResponseBody
    @JsonFormat
    public CedulaIdentidad updateCedulaIdentidad(@PathVariable(value = "documentoId") String documentoId,
                                                 @PathVariable(value = "liquidacionSueldo") String cedulaIdentidadId,
                                                 @Valid @RequestBody CedulaIdentidad cedulaIdentidadrequest) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("ID " + documentoId + " not found");
        }

        return cedulaidentidadrepo.findById(cedulaIdentidadId).map(cedulaIdentidad -> {
            cedulaIdentidad.setIdCedula(cedulaIdentidadrequest.getIdCedula());
            cedulaIdentidad.setDescripcion(cedulaIdentidadrequest.getDescripcion());
            return cedulaidentidadrepo.save(cedulaIdentidad);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + cedulaIdentidadId + "not found"));
    }

    //    DELETE MAPPING:
    @DeleteMapping("/documento/{documentoId}/cedulaIdentidad/{cedulaIdentidadId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteCdulaIdentidad(@PathVariable(value = "documentoId") String documentoId,
                                                  @PathVariable(value = "cedulaIdentidadId") String cedulaIdentidadId) {
        if (!documentorepo.existsById(documentoId)) {
            throw new ResourceNotFoundExcption("Id" + documentoId + " not found");
        }

        return cedulaidentidadrepo.findById(cedulaIdentidadId).map(cedulaIdentidad -> {
            cedulaidentidadrepo.delete(cedulaIdentidad);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("CommentId " + cedulaIdentidadId + " not found"));
    }
}
