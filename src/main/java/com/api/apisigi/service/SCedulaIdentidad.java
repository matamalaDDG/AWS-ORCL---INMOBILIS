package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.CedulaIdentidad;
import com.api.apisigi.repository.IRCedulaIdentidad;

@Service("cedulaIdentidadServices")
public class SCedulaIdentidad {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("cedulaIdentidadRepo")
    private IRCedulaIdentidad cedulaIdentidadrepo;


    //#CREATE
    public boolean create(CedulaIdentidad cedulaIdentidad) {
        try {
            cedulaIdentidadrepo.save(cedulaIdentidad);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //public List<MBoletaHonorario> read(){}
    //#UPDATE
    public boolean update(CedulaIdentidad cedulaIdentidad) {
        try {
            cedulaIdentidadrepo.save(cedulaIdentidad);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            cedulaIdentidadrepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
