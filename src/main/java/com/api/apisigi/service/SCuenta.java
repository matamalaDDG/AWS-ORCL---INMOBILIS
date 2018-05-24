package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Cuenta;
import com.api.apisigi.repository.IRCuenta;

@Service("cuentaService")
public class SCuenta {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("cuentaRepo")
    private IRCuenta cuentarepo;

    //#CREATE
    public boolean create(Cuenta cuenta) {
        try {
            cuentarepo.save(cuenta);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Cuenta cuenta) {
        try {
            cuentarepo.save(cuenta);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            cuentarepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
