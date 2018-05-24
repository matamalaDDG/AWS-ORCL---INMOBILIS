package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.HistArriendo;
import com.api.apisigi.repository.IRHistArriendo;

@Service("histArriendoService")
public class SHistArriendo {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("histArriendoRepo")
    private IRHistArriendo estadorepo;

    //#CREATE
    public boolean create(HistArriendo histArriendo) {
        try {
            estadorepo.save(histArriendo);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(HistArriendo histArriendo) {
        try {
            estadorepo.save(histArriendo);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            estadorepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
