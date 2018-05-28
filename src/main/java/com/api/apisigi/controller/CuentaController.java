package com.api.apisigi.controller;

import com.api.apisigi.entity.Cuenta;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRCuenta;
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
@RequestMapping("/api/clientes")
public class CuentaController {

    public static final Log logger = LogFactory.getLog(CuentaController.class);

    @Autowired
    @Qualifier("cuentaRepo")
    private IRCuenta cuentarepo;


    @GetMapping("/cuentas/cuentasusuarios")
    @ResponseBody
    @JsonFormat
    public List<Cuenta> getAllAccounts() {
        logger.info("[Buscando CUENTAS : ROUTE: /api/clientes .... Method: getAllAccounts]");
        logger.info("[Listando CUENTAS : ROUTE: /api/clientes .... Method: getAllAccounts]");
        logger.info("[CUENTAS Listadas : ROUTE: /api/clientes.... Method: getAllAccounts]");
        List temp_accounts = new ArrayList();
        cuentarepo.findAll().forEach(temp_accounts::add);
        return temp_accounts;
        //return regionre.findAll().;
    }

    //#ROUTE METHODS
    //#POST METHOD: INSERCION REGION
    @PostMapping("/cuentas/cuentasusuarios/nuevacuenta")
    @ResponseBody
    @JsonFormat
    public void createCuenta(@Valid @RequestBody Cuenta cuenta) {
        logger.info("[CREANDO CUENTA : ROUTE: /cuentas/cuentasusuarios/nuevacuenta ----- Nuevo usuario" + cuenta.getUsuario() + ".... Method: createCuenta]");
        if (!cuentarepo.validarPorUsuario(cuenta.getUsuario())) {
            cuentarepo.save(cuenta);
        }
        logger.error("[CREANDO CUENTA : ROUTE: /cuentas/cuentasusuarios/nuevacuenta" + cuenta.getUsuario() + ".... Method: createCuenta...usuario ya existe]");

    }

    @DeleteMapping("/cuentas/cuentasusuarios/cuenta/{cuentaId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> eliminarCuenta(@PathVariable String cuentaId) {
        logger.info("[ELIMINANDO CUENTA : ROUTE: /cuentas/cuentasusuarios/cuenta----- Nuevo usuario .... Method: eliminarCuenta]");
        return cuentarepo.findById(cuentaId).map(cuenta -> {
            cuentarepo.delete(cuenta);
            logger.info("[region eliminada: /dregion/{regionId}.... Method: deletePost .... state: success]");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + cuentaId + " not found"));
    }

    //#UPDATE REGION
    @PutMapping("/cuentas/cuentasusuarios/cuenta/{idCuenta}")
    @ResponseBody
    @JsonFormat
    public Cuenta actualizarCuenta(@PathVariable String idCuenta,
                             @Valid @RequestBody Cuenta cuentarequest) {
        return cuentarepo.findById(idCuenta).map(cuenta -> {
            cuenta.setUsuario(cuentarequest.getUsuario());
            cuenta.setPassword(cuentarequest.getPassword());
            return cuentarepo.save(cuenta);
        }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idCuenta + " not found"));
    }


}
