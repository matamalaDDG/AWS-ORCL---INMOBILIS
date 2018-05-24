package com.api.apisigi.service;

import com.api.apisigi.entity.Arriendo;
import com.api.apisigi.repository.IRVenta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ventaServices")
public class SVenta {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);




    //#CREATE
    public boolean create(Arriendo arriendo) {

        try {
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //mpublic List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Arriendo arriendo) {
        try {
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
