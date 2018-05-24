package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Comuna;
import com.api.apisigi.repository.IRComuna;

@Service("comunaServices")
public class SComuna {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("comunaRepo")
    private IRComuna comunarepo;

    //#CREATE
    public boolean create(Comuna comuna) {
        try {
            comunarepo.save(comuna);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Comuna comuna) {
        try {
            comunarepo.save(comuna);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            comunarepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}