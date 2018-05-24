package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Propiedad;
import com.api.apisigi.repository.IRPropiedad;

@Service("propiedadService")
public class SPropiedad {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("propiedadRepo")
    private IRPropiedad propiedadrepo;

    //#CREATE
    public boolean create(Propiedad propiedad) {
        try {
            propiedadrepo.save(propiedad);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Propiedad propiedad) {
        try {
            propiedadrepo.save(propiedad);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            propiedadrepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
