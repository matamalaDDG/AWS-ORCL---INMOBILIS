package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Edificio;
import com.api.apisigi.repository.IREdificio;

@Service("edificioService")
public class SEdificio {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("edificioRepo")
    private IREdificio edificioRepo;

    //#CREATE
    public boolean create(Edificio edificio) {
        try {
            edificioRepo.save(edificio);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Edificio edificio) {
        try {
            edificioRepo.save(edificio);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            edificioRepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
