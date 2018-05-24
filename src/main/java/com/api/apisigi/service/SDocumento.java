package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Documento;
import com.api.apisigi.repository.IRDocumento;

@Service("documentoService")
public class SDocumento {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("documentoRepo")
    private IRDocumento documentoRepo;

    //#CREATE
    public boolean create(Documento departamento) {
        try {
            documentoRepo.save(departamento);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Documento departamento) {
        try {
            documentoRepo.save(departamento);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            documentoRepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
