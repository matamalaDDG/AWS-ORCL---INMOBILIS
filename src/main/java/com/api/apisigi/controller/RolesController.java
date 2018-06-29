package com.api.apisigi.controller;

import com.api.apisigi.entity.Roles;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.IRRoles;
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
@RequestMapping("/api/cuentas/roles")
public class RolesController {
    public static final Log logger = LogFactory.getLog(RolesController.class);

    @Autowired
    @Qualifier("rolesrepo")
    private IRRoles rolesrepo;

    //##GET ALL ROLES
    @GetMapping("/roles")
    @ResponseBody
    @JsonFormat
    public List<Roles> getAllRoles() {

        try {
            logger.info("[Buscando Roles : ROUTE: /roles .... Method: getAllRoles]");
            logger.info("[Listando Roles : ROUTE: /roles .... Method: getAllRoles]");
            logger.info("[Roles Listados : ROUTE: /roles.... Method: getAllRoles]");
            List temp_Roles = new ArrayList<>();
            rolesrepo.findAll().forEach(temp_Roles::add);

            return temp_Roles;

        } catch (Exception ex) {

            logger.error("[Error Listando Roles : ROUTE: /roles.... Method: getAllRoles]" + ex.getMessage());
            return null;
        }

    }

    //#ROUTE METHODS
    //#POST METHOD: INSERCION REGION
    @PostMapping("/region")
    @ResponseBody
    @JsonFormat
    public void creandoRoles(@Valid @RequestBody Roles roles) {

        try {
            logger.info("[creando Roles : ROUTE: .... Method: createRegion]");
            logger.info("[Roles creado : ROUTE: .... Method: createRegion]");
            rolesrepo.save(roles);
        } catch (Exception ex) {
            return ;
        }

    }
    //#DELETE ROLES
    @DeleteMapping("/roles/{rolesid}")
    @ResponseBody
    @JsonFormat
    public ResponseEntity<?> deleteRoles(@PathVariable String rolesid) {

        logger.info("[buscado region : .... Method: deletePost]");

        try {
            return rolesrepo.findById(rolesid).map(roles -> {
                logger.info("[Eliminando roles : /roles/{rolesid} .... Method: deleteRoles]");
                rolesrepo.delete(roles);
                logger.info("[roles eliminada: /roles/{rolesid}.... Method: deleteRoles .... state: success]");
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundExcption("rolesid " + rolesid + " not found"));
        } catch (Exception ex) {
            return null;
        }

    }

    //#UPDATE ROLES
    @PutMapping("/roles/{rolesid}")
    @ResponseBody
    @JsonFormat
    public Roles updatePost(@PathVariable String rolesid,
                            @Valid @RequestBody Roles rolesrequest) {
        try {
            return rolesrepo.findById(rolesid).map(region -> {
                region.setRol(rolesrequest.getRol());
                return rolesrepo.save(region);
            }).orElseThrow(() -> new ResourceNotFoundExcption("PostId " + rolesid + " not found"));
        }catch (Exception ex){
            return null;
        }

    }

}
