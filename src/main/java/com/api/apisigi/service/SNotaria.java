package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Notaria;
import com.api.apisigi.repository.IRNotaria;

@Service("notariaService")
public class SNotaria {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("notariaRepo")
    private IRNotaria notariarepo;

    //#CREATE
    public boolean create(Notaria notaria) {
        try {
            notariarepo.save(notaria);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Notaria notaria) {
        try {
            notariarepo.save(notaria);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            notariarepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
