package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.PatenteComercial;
import com.api.apisigi.repository.IRPatenteComercial;

@Service("patenteComercialService")
public class SPatenteComercial {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("patenteComercialRepo")
    private IRPatenteComercial notariarepo;

    //#CREATE
    public boolean create(PatenteComercial patenteComercial) {
        try {
            notariarepo.save(patenteComercial);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(PatenteComercial patenteComercial) {
        try {
            notariarepo.save(patenteComercial);
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
