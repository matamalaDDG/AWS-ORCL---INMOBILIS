package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Estado;
import com.api.apisigi.repository.IREstado;

@Service("estadoService")
public class SEstado {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("estadoRepo")
    private IREstado estadorepo;

    //#CREATE
    public boolean create(Estado estado) {
        try {
            estadorepo.save(estado);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Estado estado) {
        try {
            estadorepo.save(estado);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            estadorepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
