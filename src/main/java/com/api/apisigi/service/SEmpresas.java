package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Empresas;
import com.api.apisigi.repository.IREmpresas;

@Service("empresaService")
public class SEmpresas {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("empresaRepo")
    private IREmpresas empresaRepo;

    //#CREATE
    public boolean create(Empresas empresa) {
        try {
            empresaRepo.save(empresa);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Empresas empresa) {
        try {
            empresaRepo.save(empresa);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            empresaRepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
