package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.LogsSessions;
import com.api.apisigi.repository.IRLogsSessions;

@Service("logsSessionsService")
public class SLogsSessions {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("logsSessionsRepo")
    private IRLogsSessions logssessionsrepo;

    //#CREATE
    public boolean create(LogsSessions logssessions) {
        try {
            logssessionsrepo.save(logssessions);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(LogsSessions logssessions) {
        try {
            logssessionsrepo.save(logssessions);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            logssessionsrepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
