package com.api.apisigi.controller;

import com.api.apisigi.entity.TipoPropiedad;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRTipoPropiedad;
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
@RequestMapping("/api/propiedades/tipopropiedad")
public class TipopropiedadController {
    public static final Log logger = LogFactory.getLog(TipopropiedadController.class);

    @Autowired
    @Qualifier("tipoPropiedadRepo")
    private IRTipoPropiedad tipopropiedadrepo;

    //#LISTADO DE COMUNAS POR ID COMUNA
    //#GET METHOD
    @GetMapping("/tipopropiedades")
    @ResponseBody
    @JsonFormat
    public List<TipoPropiedad> getAllTipoPropiedad() {
        try {
            logger.info("[Buscando TipoPropiedad : ROUTE: /TipoPropiedad .... Method: getAllTipoPropiedad]");
            logger.info("[Listando TipoPropiedad : ROUTE: /TipoPropiedad .... Method: getAllTipoPropiedad]");
            logger.info("[TipoPropiedad Listadas : ROUTE: /TipoPropiedad.... Method: getAllTipoPropiedad]");
            List temp_TipoPropiedad = new ArrayList<>();
            tipopropiedadrepo.findAll().forEach(temp_TipoPropiedad::add);
            //regionre.deleteAll(temp_Regiones);
            return temp_TipoPropiedad;
            //return regionre.findAll().;

        } catch (Exception ex) {
            logger.error("[Error Regiones Listadas : ROUTE: /regiones.... Method: getAllRegiones]" + ex.getMessage());
            return null;
        }
    }

    @PostMapping("/tipopropiedad")
    @ResponseBody
    @JsonFormat
    public TipoPropiedad createTipoPropiedad(@Valid @RequestBody TipoPropiedad tipoPropiedad) {
        logger.info("[creando tipopropiedad : ROUTE: /tipopropiedad.... Method: createTipoPropiedad]");
        return tipopropiedadrepo.save(tipoPropiedad);
    }

    @DeleteMapping("/tipoprop/{tipopropiedadId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteTipoProp(@PathVariable String tipopropiedadId) {
        logger.info("[buscado tipopropiedad : tipoprop :/tipoprop .... Method: deleteTipoProp]");
        try {
            return tipopropiedadrepo.findById(tipopropiedadId).map(tipoPropiedad -> {
                logger.info("[Eliminando tipo propiedad ....  tipoprop :/tipoprop .... Method: deleteTipoProp]");
                tipopropiedadrepo.delete(tipoPropiedad);
                logger.info("[Tipo propiedad Eliminada -> tipoprop :/tipoprop.... Method: deleteTipoProp .... state: success]");
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + tipopropiedadId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error eliminando Tipo propiedad -> tipoprop :/tipoprop.... Method: deleteTipoProp .... state: success]");
            return null;
        }
    }

    //#UPDATE REGION
    @PutMapping("/tipopropiedad/{tipopropiedadid}")
    @ResponseBody
    @JsonFormat
    public void updatePost(@PathVariable String tipopropiedadId,
                           @Valid @RequestBody TipoPropiedad tipopropiedadrequest) {
        try {
            tipopropiedadrepo.findById(tipopropiedadId).map(tipopropiedad -> {
                tipopropiedad.setIdTipoProp(tipopropiedadrequest.getIdTipoProp());
                tipopropiedad.setDescripcion(tipopropiedadrequest.getDescripcion());
                return tipopropiedadrepo.save(tipopropiedad);
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + tipopropiedadId + " not found"));
        } catch (Exception ex) {
            logger.error("[Error Actualizando Tipo propiedad -> tipoprop :/tipoprop.... Method: deleteTipoProp .... state: success]");
            return;
        }
    }

}
