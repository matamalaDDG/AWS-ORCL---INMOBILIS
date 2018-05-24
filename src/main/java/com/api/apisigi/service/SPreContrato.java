package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Precontrato;
import com.api.apisigi.repository.IRPrecontrato;

@Service("preContratoService")
public class SPreContrato {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("preContratoRepo")
    private IRPrecontrato precontratorepo;

    //#CREATE
    public boolean create(Precontrato precontrato) {
        try {
            precontratorepo.save(precontrato);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Precontrato precontrato) {
        try {
            precontratorepo.save(precontrato);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            precontratorepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
