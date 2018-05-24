package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.TipoPropiedad;
import com.api.apisigi.repository.IRTipoPropiedad;

@Service("tipoPropiedadService")
public class STipoPropiedad {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);
    @Autowired
    @Qualifier("tipoPropiedadRepo")
    private IRTipoPropiedad tipopropiedadrepo;

    //#CREATE
    public boolean create(TipoPropiedad tipopropiedad) {
        try {
            tipopropiedadrepo.save(tipopropiedad);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(TipoPropiedad tipopropiedad) {
        try {
            tipopropiedadrepo.save(tipopropiedad);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            tipopropiedadrepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
