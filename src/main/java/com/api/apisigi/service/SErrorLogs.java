package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.ErrorLogs;
import com.api.apisigi.repository.IRErrorLogs;

@Service("errorLogsService")
public class SErrorLogs {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);


    @Autowired
    @Qualifier("errorLogsRepo")
    private IRErrorLogs errorlogsrepo;

    //#CREATE
    public boolean create(ErrorLogs errorlogs) {
        try {
            errorlogsrepo.save(errorlogs);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(ErrorLogs errorlogs) {
        try {
            errorlogsrepo.save(errorlogs);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            errorlogsrepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
