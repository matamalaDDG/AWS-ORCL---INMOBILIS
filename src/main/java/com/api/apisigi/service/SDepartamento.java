package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Departamento;
import com.api.apisigi.repository.IRDepartamento;

@Service("departamentoService")
public class SDepartamento {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("departamentoRepo")
    private IRDepartamento departamentoRepo;

    //#CREATE
    public boolean create(Departamento departamento) {
        try {
            departamentoRepo.save(departamento);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(Departamento departamento) {
        try {
            departamentoRepo.save(departamento);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            departamentoRepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
