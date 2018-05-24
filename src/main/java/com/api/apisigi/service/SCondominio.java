package com.api.apisigi.service;

import com.api.apisigi.repository.IRCondominio;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Condominio;


@Service("condominioService")
public class SCondominio {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);
    @Autowired
    @Qualifier("condominioRepo")
    private IRCondominio condominiorepo;

    //#CREATE
    public boolean create(Condominio condominio) {
        try {
            condominiorepo.save(condominio);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Condominio condominio) {
        try {
            condominiorepo.save(condominio);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            condominiorepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
