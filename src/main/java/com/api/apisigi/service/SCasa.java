package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Casa;
import com.api.apisigi.repository.IRCasa;

@Service("casaServices")
public class SCasa {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("casaRepo")
    private IRCasa casarepo;

    //Converter

    //#CREATE
    public boolean create(Casa casa) {
        try {
            casarepo.save(casa);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //public List<MBoletaHonorario> read(){}
    //#UPDATE
    public boolean update(Casa casa) {
        try {
            casarepo.save(casa);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete() {
        try {
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
