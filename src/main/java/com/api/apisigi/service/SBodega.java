package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Bodega;
import com.api.apisigi.repository.IRBodega;

@Service("bodegaService")
public class SBodega {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);


    @Autowired
    @Qualifier("bodegaRepo")
    private IRBodega bodegarepo;


    //#CREATE
    public boolean create(Bodega bodega) {
        logger.info("[ FUNCTION: CREATE -- " +
                "  SERVICE: BODEGA -- " +
                "  MESSAGE: CREANDO BODEGA....]");
        try {
            //FUNCTION
            bodegarepo.save(bodega);
            logger.info("[ FUNCTION: CREATE -- " +
                    "  SERVICE: BODEGA -- " +
                    "  MESSAGE: BODEGA CREADA]");
            return true;
        } catch (Exception ex) {
            logger.info("[ FUNCTION: CREATE -- " +
                    "  SERVICE: BODEGA -- " +
                    "  MESSAGE: ERROR AL CREAR BODEGA]");
            return false;
        }
    }

    //#READ ARRIENDO
    /*public List<MArriendo> listadoArrinedos() {
        logger.info("[ FUNCTION: READ -- " +
                "  SERVICE: ARRIENDO -- " +
                "  MESSAGE: LISTANDO ARRIENDOS....]");
        //return arriendoConverter.listConverter(arriendorepo.findAll());
        return arriendoconverter.listConverter(arriendorepo.findAll());
    }*/

    //#UPDATE
    public boolean update() {
        logger.info("[ FUNCTION: UPDATE -- " +
                "  SERVICE: BODEGA -- " +
                "  MESSAGE: ACTUALIZANDO BODEGA....]");
        try {
            //FUNCTION

            logger.info("[ FUNCTION: UPDATE -- " +
                    "  SERVICE: BODEGA -- " +
                    "  MESSAGE: BODEGA ACTUALIZADA]");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete() {
        logger.info("[ FUNCTION: DELETE -- " +
                "  SERVICE: BODEGA -- " +
                "  MESSAGE: ELIMINANDO BODEGA....]");
        try {
            //FUNCTION

            logger.info("[ FUNCTION: DELETE -- " +
                    "  SERVICE: BODEGA -- " +
                    "  MESSAGE: BODEGA ELIMINADA]");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
