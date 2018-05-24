package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Conservador;
import com.api.apisigi.repository.IRConservador;

@Service("conservadorService")
public class SConservador {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    //# injeccion de depencias del sistema
    @Autowired
    @Qualifier("conservadorRepo")
    private IRConservador conservadorRepo;

    //#CREATE
    public boolean create(Conservador conservador) {
        try {
            conservadorRepo.save(conservador);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    // public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Conservador conservador) {
        try {
            conservadorRepo.save(conservador);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            conservadorRepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
