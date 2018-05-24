package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Oficina;
import com.api.apisigi.repository.IROficina;

@Service("oficinaService")
public class SOficina {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("oficinaRepo")
    private IROficina notariarepo;

    //#CREATE
    public boolean create(Oficina oficina) {
        try {
            notariarepo.save(oficina);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Oficina oficina) {
        try {
            notariarepo.save(oficina);
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
