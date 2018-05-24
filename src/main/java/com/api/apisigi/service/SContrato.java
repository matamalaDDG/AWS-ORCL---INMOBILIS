package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Contrato;
import com.api.apisigi.repository.IRContrato;

@Service("contratoService")
public class SContrato {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);
    //#INJECCION DE DEPENDENCIAS
    @Autowired
    @Qualifier("contratoRepo")
    private IRContrato contratorepo;


    //#CREATE
    public boolean create(Contrato contrato) {
        try {
            contratorepo.save(contrato);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //public List<M> read(){return sadsa;}
    //#UPDATE
    public boolean update(Contrato contrato) {
        try {
            contratorepo.save(contrato);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            contratorepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
