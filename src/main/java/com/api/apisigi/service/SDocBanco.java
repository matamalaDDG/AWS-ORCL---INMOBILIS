package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.DocBanco;
import com.api.apisigi.repository.IRDocBanco;

@Service("docbancoService")
public class SDocBanco {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("docbancoRepo")
    private IRDocBanco docbancorepo;

    //#CREATE
    public boolean create(DocBanco docBanco) {
        try {
            docbancorepo.save(docBanco);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(DocBanco docBanco) {
        try {
            docbancorepo.save(docBanco);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            docbancorepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
