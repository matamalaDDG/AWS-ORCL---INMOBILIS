package com.api.apisigi.controller;

import com.api.apisigi.entity.Propiedad;
import com.api.apisigi.exception.ResourceNotFoundExcption;
import com.api.apisigi.repository.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/inmobiliaria/propiedades")
public class PropiedadController {
    public static final Log logger = LogFactory.getLog(PropiedadController.class);

    @Autowired
    @Qualifier("propiedadRepo")
    private IRPropiedad propeidadrepo;

    //#propiedad
    @Autowired
    @Qualifier("ventaRepo")
    private IRVenta ventarepo;

    //#ARRIENDO
    @Autowired
    @Qualifier("arriendoRepo")
    private IRArriendo ariendorepo;

    //#ESTADO
    @Autowired
    @Qualifier("estadoRepo")
    private IREstado estadoRepo;

    //#TIPOPROPIEDAD
    @Autowired
    @Qualifier("tipoPropiedadRepo")
    private IRTipoPropiedad tipoPropiedadrepo;
    //#COMUNA
    @Autowired
    @Qualifier("comunaRepo")
    private IRComuna comunarepo;
    //#OFICINA
    @Autowired
    @Qualifier("oficinaRepo")
    private IROficina oficinarepo;
    //#CASA
    @Autowired
    @Qualifier("casaRepo")
    private IRCasa casarepo;
    //#DEPARTAMENTO
    @Autowired
    @Qualifier("departamentoRepo")
    private IRDepartamento departamentorepo;
    //#ESTACIONAMIENTO
    @Autowired
    @Qualifier("estacionamientoRepo")
    private IREstacionamiento estacionamientorepo;
    //#PERFILCLIENTE
    @Autowired
    @Qualifier("perfilClienteRepo")
    private IRPerfilCliente perfilClienterepo;

    //#ROUTE METHODS
    //#POST METHOD: INSERCION propiedad
    @GetMapping("/propiedades/listadopropiedades/publicadas")
    @ResponseBody
    @JsonFormat
    public List<Propiedad> listadoPropiedades() {
        //TODO Agregar LOGS
        logger.info("[Buscando Propiedades : ROUTE: /Propiedades .... Method: listadoPropiedades]");
        logger.info("[Listando Propiedades : ROUTE: /Propiedades .... Method: listadoPropiedades]");
        logger.info("[Propiedades Listadas : ROUTE: /Propiedades.... Method: listadoPropiedades]");
        try {
            List temp_propiedad = new ArrayList();
            propeidadrepo.findAll().forEach(temp_propiedad::add);
            return temp_propiedad;
            //return regionre.findAll().;
        }
        catch (Exception ex){
            logger.error("[Error al listar propiedades : ROUTE: /Propiedades.... Method: listadoPropiedades]");
            return null;
        }
    }

    //#POST METHOD: INSERCION DEPARTAMENTO + IDEDIFICIO
    @PostMapping("/procesopublicacion/propiedad/estado/{idestado}/{idventa}/{idarriendo}/tipoprop/{idtipoprop}/ubicacion/{idcomuna}/{idoficina}/{idcasa}/{idventa}/{idepto}/{idestacionamiento}/usuario/{idperfil}/nueva")
    @ResponseBody
    @JsonFormat
    public void createpropiedad(@PathVariable(value = "idestado") String idestado,
                                @PathVariable(value = "idtipoprop") String idtipoprop,
                                @PathVariable(value = "idcomuna") String idcomuna,
                                @PathVariable(value = "idoficina") String idoficina,
                                @PathVariable(value = "idcasa") String idcasa,
                                @PathVariable(value = "idventa") String idventa,
                                @PathVariable(value = "idepto") String idepto,
                                @PathVariable(value = "idestacionamiento") String idestacionamiento,
                                @PathVariable(value = "idarriendo") String idarriendo,
                                @PathVariable(value = "idperfil") String idperfil,
                                @Valid @RequestBody Propiedad propiedad) {
        logger.info("[Agregando Propiedades : ROUTE: /Propiedades .... Method: listadoPropiedades]");
        logger.info("[Insertando Propiedades...... : ROUTE: /Propiedades .... Method: listadoPropiedades]");
        try {
            //#CONSERVADOR
            estadoRepo.findById(idestado).map(estado -> {
                propiedad.setEstado(estado);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idestado + " not found"));
            //#CONVENIO
            tipoPropiedadrepo.findById(idtipoprop).map(tipoPropiedad -> {
                propiedad.setTipopropiedad(tipoPropiedad);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idtipoprop + " not found"));

            //#DOCBANCO
            comunarepo.findById(idcomuna).map(comuna -> {
                propiedad.setComuna(comuna);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idcomuna + " not found"));

            //#DOCNOTARIA
            oficinarepo.findById(idoficina).map(oficina -> {
                propiedad.setOficina(oficina);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idoficina + " not found"));

            //#SERVICIO
            casarepo.findById(idcasa).map(casa -> {
                propiedad.setCasa(casa);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idcasa + " not found"));

            //#VENTA
            ventarepo.findById(idventa).map(venta -> {
                propiedad.setVenta(venta);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("edificioId " + idventa + " not found"));

            //#CONSERVADOR
            departamentorepo.findById(idepto).map(departamento -> {
                propiedad.setDepartamento(departamento);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("id " + idepto + " not found"));

            //#CONSERVADOR
            estacionamientorepo.findById(idestacionamiento).map(estacionamiento -> {
                propiedad.setEstacionamiento(estacionamiento);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("id " + idepto + " not found"));

            //#CONSERVADOR
            ariendorepo.findById(idarriendo).map(arriendo -> {
                propiedad.setArriendo(arriendo);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("id " + idepto + " not found"));

            //#CONSERVADOR
            perfilClienterepo.findById(idperfil).map(perfilCliente -> {
                propiedad.setPerfilcliente(perfilCliente);
                return propiedad;
            }).orElseThrow(() -> new ResourceNotFoundExcption("id " + idepto + " not found"));
            propeidadrepo.save(propiedad);
            logger.info("[Propiedades insertada : ROUTE: /Propiedades.... Method: listadoPropiedades]");

        } catch (Exception ex) {
            return;
        }
    }

    //#PUT METHOD: ACTUALIZACION DE VENTA
    @PutMapping("/procesopublicacion/propiedad/estado/{idestado}/{idventa}/{idarriendo}/tipoprop/{idtipoprop}/ubicacion/{idcomuna}/{idoficina}/{idcasa}/{idventa}/{idepto}/{idestacionamiento}/usuario/{idperfil}/propiedad/{idpropiedad}")
    public Propiedad updatedePropiedad(@PathVariable(value = "idestado") String idestado,
                                       @PathVariable(value = "idtipoprop") String idtipoprop,
                                       @PathVariable(value = "idcomuna") String idcomuna,
                                       @PathVariable(value = "idoficina") String idoficina,
                                       @PathVariable(value = "idcasa") String idcasa,
                                       @PathVariable(value = "idventa") String idventa,
                                       @PathVariable(value = "idepto") String idepto,
                                       @PathVariable(value = "idestacionamiento") String idestacionamiento,
                                       @PathVariable(value = "idarriendo") String idarriendo,
                                       @PathVariable(value = "idperfil") String idperfil,
                                       @Valid @RequestBody Propiedad propiedadrequest) {
        if (!estadoRepo.existsById(idestado) || idestado != "null" ||
                !tipoPropiedadrepo.existsById(idtipoprop) || idtipoprop != "null" ||
                !comunarepo.existsById(idcomuna) || idcomuna != "null" ||
                !oficinarepo.existsById(idoficina) || idoficina != "null" ||
                !casarepo.existsById(idcasa) || idcasa != "null" ||
                !ventarepo.existsById(idventa) || idventa != "null" ||
                !departamentorepo.existsById(idepto) || idepto != "null" ||
                !departamentorepo.existsById(idarriendo) || idarriendo != "null" ||
                !departamentorepo.existsById(idestacionamiento) || idestacionamiento != "null" ||
                !departamentorepo.existsById(idperfil) || idperfil != "null") {
            throw new ResourceNotFoundExcption("ID " + idtipoprop + "not found," +
                    "ID " + idcomuna + "not found," +
                    "ID " + idoficina + "not found," +
                    "ID " + idcasa + "not found," +
                    "ID " + idventa + "not found," +
                    "ID " + idepto + "not found," +
                    "ID " + idestacionamiento + "not found," +
                    "ID " + idarriendo + "not found," +
                    "ID " + idperfil + "not found.");
        }
        logger.info("[Modificando Propiedades : ROUTE: /Propiedades .... Method: listadoPropiedades]");
        try {
            logger.info("[Se esta modificando Propiedades...... : ROUTE: /Propiedades .... Method: listadoPropiedades]");
            return propeidadrepo.findPropiedadByEstadoAndTipopropiedadAndComunaAndOficinaAndCasaAndVentaAndDepartamentoAndEstacionamientoAndArriendoAndPerfilcliente(idestado, idtipoprop, idcomuna, idoficina, idcasa, idventa, idepto, idestacionamiento, idarriendo, idperfil).map(propiedad -> {
                propiedad.setDireccion(propiedadrequest.getDireccion());
                propiedad.setTipoDueno(propiedadrequest.getTipoDueno());
                propiedad.setTipoDueno(propiedadrequest.getTipoDueno());
                logger.info("[Propiedades Modificada...... : ROUTE: /Propiedades .... Method: listadoPropiedades]");
                return propeidadrepo.save(propiedad);

            }).orElseThrow(() -> new ResourceNotFoundExcption("ID " + idtipoprop + "not found," +
                    "ID " + idcomuna + "not found," +
                    "ID " + idoficina + "not found," +
                    "ID " + idcasa + "not found," +
                    "ID " + idventa + "not found," +
                    "ID " + idepto + "not found," +
                    "ID " + idestacionamiento + "not found," +
                    "ID " + idarriendo + "not found," +
                    "ID " + idperfil + "not found."));
        } catch (Exception ex) {
            return null;
        }
    }
}


