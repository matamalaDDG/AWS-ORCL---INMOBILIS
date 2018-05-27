package com.api.apisigi.controller;

import com.api.apisigi.entity.Documento;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRDocumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    //    INYECCION DE DEPENDENCIAS
    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentorepo;

    //    GET MAPPING
    @GetMapping("/documentos")
    @ResponseBody
    @JsonFormat
    public List<Documento> getAll() {
        return documentorepo.findAll();
    }

    //TODO
    //    GET MAPPING: ById
    //    GET MAPPING: ByDescripcion
    //    GET MAPPING: ByDocumento


    //    POST MAPPING
    @PostMapping("/ndocumento")
    @ResponseBody
    @JsonFormat
    public Documento createDocumento(@Valid @RequestBody Documento documento) {
        // logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return documentorepo.save(documento);
    }

    //    UPDATE MAPPING
    @PutMapping("/udocumento/{documentoId}")
    @ResponseBody
    @JsonFormat
    public Documento updateDocumento(@PathVariable String documentoId,
                                     @Valid @RequestBody Documento documentorequest) {
        return documentorepo.findById(documentoId).map(documento -> {
            documento.setIdDocumento(documentorequest.getIdDocumento());
            documento.setDescripcion(documentorequest.getDescripcion());
            documento.setDocumento(documentorequest.getDocumento());
            return documentorepo.save(documento);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + documentoId + " not found"));
    }

    //    DELETE MAPPING
    @DeleteMapping("/ddocumento/{documentoId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String documentoId) {
        //    logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return documentorepo.findById(documentoId).map(documento -> {
            //        logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            documentorepo.delete(documento);
            //         logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + documentoId + " not found"));
    }

}
