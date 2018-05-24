package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.converter.ArriendoConverter;
import com.api.apisigi.entity.Arriendo;
import com.api.apisigi.model.MArriendo;
import com.api.apisigi.repository.IRArriendo;

import java.util.List;

@Service("arriendoService")
public class SArriendo {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    //dependencias
    @Autowired
    @Qualifier("arriendoRepo")
    private IRArriendo arriendorepo;

    @Autowired
    @Qualifier("arriendoConverter")
    private ArriendoConverter arriendoconverter;


    /*CREATE*/
    public boolean crear(Arriendo arriendo) {
        logger.info("[ FUNCTION: CREATE -- " +
                "  SERVICE: ARRIENDO -- " +
                "  MESSAGE: CREANDO ARRIENDO....]");
        try {
            logger.info("[ FUNCTION: CREATE -- " +
                    "  SERVICE: ARRIENDO -- " +
                    "  MESSAGE: ARRIENDO CREADO....]");
            arriendorepo.save(arriendo);
            return true;
        } catch (Exception e) {
            logger.error("[ FUNCTION: CREATE -- " +
                    "  SERVICE: ARRIENDO -- " +
                    "  MESSAGE: ERROR CREANDO ARRIENDO....]");
            return false;
        }
    }

    /*UPDATE*/
    public boolean actualizar(Arriendo arriendo) {
        logger.info("[ FUNCTION: UPDATE -- " +
                "  SERVICE: ARRIENDO -- " +
                "  MESSAGE: ACTUALIZANDO ARRIENDO....]");
        try {
            logger.info("[ FUNCTION: UPDATE -- " +
                    "  SERVICE: ARRIENDO -- " +
                    "  MESSAGE: ARRIENDO ACTUALIZADO...]");
            arriendorepo.save(arriendo);
            return true;
        } catch (Exception e) {
            logger.error("[ FUNCTION: UPDATE -- " +
                    "  SERVICE: ARRIENDO -- " +
                    "  MESSAGE: ERROR ACTUALIZANDO ARRIENDO...]");
            return false;
        }
    }

    //#READ ARRIENDO
    public List<MArriendo> listadoArrinedos() {
        logger.info("[ FUNCTION: READ -- " +
                "  SERVICE: ARRIENDO -- " +
                "  MESSAGE: LISTANDO ARRIENDOS....]");
        //return arriendoConverter.listConverter(arriendorepo.findAll());
        return arriendoconverter.listConverter(arriendorepo.findAll());
    }

    //#DELETE ARRIENDO
    public boolean delete(String id) {
        logger.info("[ FUNCTION: DELETE -- " +
                "  SERVICE: ARRIENDO -- " +
                "  MESSAGE: ELIMINANDO ARRIENDO....]");
        try {
            Long tempId = Long.parseLong(id, id.length());
            arriendorepo.deleteById(tempId);
            logger.info("[ FUNCTION: DELETE -- " +
                    "  SERVICE: ARRIENDO -- " +
                    "  MESSAGE: ARRIENDO ELIMINADO....]");
            return true;
        } catch (Exception ex) {
            logger.error("[ FUNCTION: DELETE -- " +
                    "  SERVICE: ARRIENDO -- " +
                    "  MESSAGE: ELIMINANDO ARRIENDO....]");
            return false;
        }
    }
}