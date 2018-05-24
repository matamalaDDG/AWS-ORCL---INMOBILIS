package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Corredor;
import com.api.apisigi.repository.IRCorredor;

@Service("corredorService")
public class SCorredor {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("corredorRepo")
    private IRCorredor corredorrepo;

    //#CREATE
    public boolean create(Corredor corredor) {
        try {
            corredorrepo.save(corredor);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Corredor corredor) {
        try {
            corredorrepo.save(corredor);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            corredorrepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
