package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Estacionamiento;
import com.api.apisigi.repository.IREstacionamiento;

@Service("estacionamientoService")
public class SEstacionamiento {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("estacionamientoRepo")
    private IREstacionamiento estacionamientorepo;

    //#CREATE
    public boolean create(Estacionamiento estacionamiento) {
        try {
            estacionamientorepo.save(estacionamiento);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Estacionamiento estacionamiento) {
        try {
            estacionamientorepo.save(estacionamiento);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            estacionamientorepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
