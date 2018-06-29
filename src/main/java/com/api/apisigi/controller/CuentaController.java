package com.api.apisigi.controller;

import com.api.apisigi.entity.Cuenta;
import com.api.apisigi.entity.Roles;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRCuenta;

import com.api.apisigi.repository.IRRoles;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.id.UUIDGenerationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/clientes")
public class CuentaController {

    //#
    public static final Log logger = LogFactory.getLog(CuentaController.class);

    @Autowired
    @Qualifier("cuentaRepo")
    private IRCuenta cuentarepo;

    @Autowired
    @Qualifier("rolesrepo")
    private IRRoles rolrepo;

    @GetMapping("/cuentas")
    @ResponseBody
    @JsonFormat
    public List<Cuenta> getAllAccounts() {
        try {
            logger.info("[Buscando CUENTAS : ROUTE: /api/clientes .... Method: getAllAccounts]");
            logger.info("[Listando CUENTAS : ROUTE: /api/clientes .... Method: getAllAccounts]");

            List temp_accounts = new ArrayList();
            cuentarepo.findAll().forEach(temp_accounts::add);

            logger.info("[CUENTAS Listadas : ROUTE: /api/clientes .... Method: getAllAccounts]");
            return temp_accounts;
        } catch (Exception ex) {
            logger.error("[CUENTAS Listadas : ROUTE: /api/clientes .... Method: getAllAccounts]");
            logger.error("[ERROR]" + ex.getMessage());
            return null;
        }
    }

    //#ROUTE METHODS
    //#POST METHOD: INSERCION
    @PostMapping("/{idrol}/cuenta")
    @ResponseBody
    @JsonFormat
    public void createCuenta(@PathVariable String idrol,
            @Valid @RequestBody Cuenta cuenta) {

        logger.info("[CREANDO CUENTA : ROUTE: /cuentas ----- Nuevo usuario :" + cuenta.getUsuario() + ".... Method: createCuenta]");
        try {
            logger.info("[CUENTA Creada : ROUTE: /cuentas ----- Nuevo usuario.... Method: createCuenta]");

            rolrepo.findById(idrol).map((rol) -> {

                int random = (int)(Math.random() * 999999 + 1);
                String id = "CUE"+ random;
                int enabled = 1;

                cuenta.setIsEnabled(enabled);
                cuenta.setIdCuenta(id);
                cuenta.setRoles(rol);
                cuentarepo.save(cuenta);
                return cuenta;
            }).orElseThrow(() -> new ResourceNotFoundExcption("idrol " + idrol + " not found"));

        } catch (Exception ex) {
            logger.error("[CUENTA Creada : ROUTE: /cuentas ----- ERROR: " + ex.getMessage() + ".... Method: createCuenta]");
            logger.info("[CUENTA]" + cuenta);
        }
    }


    @DeleteMapping("/cuentas/cuentasusuarios/rol/{idrol}/cuenta/{cuentaId}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> eliminarCuenta(@PathVariable String idrol,
                                            @PathVariable String cuentaId) {
        try {
            logger.info("[ELIMINANDO CUENTA : ROUTE: /cuentas/cuentasusuarios/cuenta .... Method: eliminarCuenta]");
            if (!rolrepo.existsById(idrol)) {
                throw new ResourceNotFoundExcption("idrol " + idrol + " not found");
            }
            return cuentarepo.findById(cuentaId).map(cuenta -> {
                cuentarepo.delete(cuenta);
                logger.info("[cuenta eliminada: .... Method: deletePost .... state: success]");
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + cuentaId + " not found"));
        } catch (Exception ex) {
            return null;
        }

    }

    //#UPDATE REGION
    @PutMapping("/cuentas/cuentasusuarios/rol/{idrol}/cuenta/{idCuenta}")
    @ResponseBody
    @JsonFormat
    public Cuenta actualizarCuenta(@PathVariable String idrol,
                                    @PathVariable String idCuenta,
                                   @Valid @RequestBody Cuenta cuentarequest) {
        try {
            if (!rolrepo.existsById(idrol)) {
                throw new ResourceNotFoundExcption("ID " + idrol + " not found");
            }
            return cuentarepo.findById(idCuenta).map(cuenta -> {
                cuenta.setUsuario(cuentarequest.getUsuario());
                cuenta.setPassword(cuentarequest.getPassword());
                return cuentarepo.save(cuenta);
            }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idCuenta + " not found"));
        } catch (Exception ex) {
            return null;
        }
    }


}
