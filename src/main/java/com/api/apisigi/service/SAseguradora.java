package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.converter.AseguradoraConverter;
import com.api.apisigi.entity.Aseguradora;
import com.api.apisigi.model.MAseguradora;
import com.api.apisigi.repository.IRAseguradora;

import java.util.List;

@Service("aseguradoraService")
public class SAseguradora {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("aseguradoraRepo")
    private IRAseguradora aseguradorepo;

    @Autowired
    @Qualifier("aseguradoraConverter")
    private AseguradoraConverter aseguradoraconverter;


    /*CREATE*/
    public boolean crear(Aseguradora aseguradora) {
        logger.error("[ FUNCTION: CREATE -- " +
                "  SERVICE: ASEGURADORA -- " +
                "  MESSAGE: CREANDO ASEGURADORA....]");
        try {
            aseguradorepo.save(aseguradora);
            logger.error("[ FUNCTION: CREATE -- " +
                    "  SERVICE: ASEGURADORA -- " +
                    "  MESSAGE: ASEGURADORA CREADA ASEGURADORA....]");
            return true;
        } catch (Exception e) {
            logger.error("[ FUNCTION: CREATE -- " +
                    "  SERVICE: ASEGURADORA -- " +
                    "  MESSAGE: ERROR CREANDO ASEGURADORA....]");
            return false;
        }
    }

    /*UPDATE*/
    public boolean actualizar(Aseguradora aseguradora) {
        logger.error("[ FUNCTION: UPDATE -- " +
                "  SERVICE: ASEGURADORA -- " +
                "  MESSAGE: MODIFICANDO ASEGURADORA....]");
        try {
            logger.info("ASEGURADORA MODIFICADA");
            aseguradorepo.save(aseguradora);
            return true;
        } catch (Exception e) {
            logger.error("[ FUNCTION: DELETE -- " +
                    "  SERVICE: ASEGURADORA -- " +
                    "  MESSAGE: ERROR MODIFICANDO ASEGURADORA....]");
            return false;
        }
    }

    //#READ ARRIENDO
    public List<MAseguradora> listadoArrinedos() {
        logger.info("[ FUNCTION: READ -- " +
                "  SERVICE: ASEGURADORA -- " +
                "  MESSAGE: LISTANDO ASEGURADORA....]");
        //return arriendoConverter.listConverter(arriendorepo.findAll());
        return aseguradoraconverter.listConverter(aseguradorepo.findAll());
    }

    //#DELETE ARRIENDO
    public boolean eliminar(String id) {
        logger.info("[ FUNCTION: DELETE -- " +
                "  SERVICE: ARRIENDO -- " +
                "  MESSAGE: ELIMINANDO ASEGURADORA....]");
        try {
            Long tempId = Long.parseLong(id, id.length());
            aseguradorepo.deleteById(tempId);
            logger.info("[ FUNCTION: DELETE -- " +
                    "  SERVICE: ARRIENDO -- " +
                    "  MESSAGE: ASEGURADORA ELIMINADA]");
            return true;
        } catch (Exception ex) {
            logger.info("[ FUNCTION: DELETE -- " +
                    "  SERVICE: ASEGURADORA -- " +
                    "  MESSAGE: ERROR ELIMINANDO ASEGURADORA]");
            return false;
        }
    }
}
