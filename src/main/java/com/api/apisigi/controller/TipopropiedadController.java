package com.api.apisigi.controller;

import com.api.apisigi.entity.TipoPropiedad;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRTipoPropiedad;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tipopropiedad")
public class TipopropiedadController {

    @Autowired
    @Qualifier("tipoPropiedadRepo")
    private IRTipoPropiedad tipopropiedadrepo;

    //#LISTADO DE COMUNAS POR ID COMUNA
    //#GET METHOD
    @GetMapping("/tipopropiedades")
    @ResponseBody
    @JsonFormat
    public List<TipoPropiedad> getAll() {
        return tipopropiedadrepo.findAll();
    }

    @PostMapping("/NTipopropiedad")
    @ResponseBody
    @JsonFormat
    public TipoPropiedad createRegion(@Valid @RequestBody TipoPropiedad tipoPropiedad) {
       // logger.info("[creando region : ROUTE: /dregion/{regionId}.... Method: createRegion]");
        return tipopropiedadrepo.save(tipoPropiedad);
    }

    @DeleteMapping("/dtipoprop/{tipopropiedadId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRegion(@PathVariable String tipopropiedadId) {
        //logger.info("[buscado region : /dregion/{regionId}.... Method: deletePost]");
        return tipopropiedadrepo.findById(tipopropiedadId).map(tipoPropiedad -> {
           // logger.info("[Eliminando region  region : /dregion/{regionId}.... Method: deletePost]");
            tipopropiedadrepo.delete(tipoPropiedad);
            //logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + tipopropiedadId + " not found"));
    }

    //#UPDATE REGION
    @PutMapping("/region/{regionId}")
    @ResponseBody
    @JsonFormat
    public TipoPropiedad updatePost(@PathVariable String tipopropiedadId,
                             @Valid @RequestBody TipoPropiedad tipopropiedadrequest) {
        return tipopropiedadrepo.findById(tipopropiedadId).map(tipopropiedad -> {
            tipopropiedad.setIdTipoProp(tipopropiedadrequest.getIdTipoProp());
            tipopropiedad.setDescripcion(tipopropiedadrequest.getDescripcion());
            return tipopropiedadrepo.save(tipopropiedad);
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + tipopropiedadId + " not found"));
    }

}
