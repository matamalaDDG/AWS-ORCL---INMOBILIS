package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Servicios;
import com.api.apisigi.repository.IRServicios;

@Service("servicioServices")
public class SServicio {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SServicio.class);

    @Autowired
    @Qualifier("servicioRepo")
    private IRServicios serviciorepo;

    //#CREATE
    public boolean create(Servicios servicios) {
        try {
            serviciorepo.save(servicios);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Servicios servicios) {
        try {
            serviciorepo.save(servicios);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            serviciorepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
