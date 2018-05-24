package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Tasacion;
import com.api.apisigi.repository.IRTasacion;

@Service("tasacionService")
public class STasacion {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("tasacionRepo")
    private IRTasacion tasacionrepo;

    //#CREATE
    public boolean create(Tasacion tasacion) {
        try {
            tasacionrepo.save(tasacion);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Tasacion tasacion) {
        try {
            tasacionrepo.save(tasacion);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            tasacionrepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
