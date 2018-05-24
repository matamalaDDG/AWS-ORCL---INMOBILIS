package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.DocNotaria;
import com.api.apisigi.repository.IRDocNotaria;

@Service("docNotariaService")
public class SDocNotaria {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("docNotariaRepo")
    private IRDocNotaria docnotariaRepo;

    //#CREATE
    public boolean create(DocNotaria docnotaria) {
        try {
            docnotariaRepo.save(docnotaria);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(DocNotaria docnotaria) {
        try {
            docnotariaRepo.save(docnotaria);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            docnotariaRepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
