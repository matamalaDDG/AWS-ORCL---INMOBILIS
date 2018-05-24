package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.PerfilCliente;
import com.api.apisigi.repository.IRPerfilCliente;

@Service("perfilClienteServices")
public class SPerfilCliente {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("perfilClienteRepo")
    private IRPerfilCliente perfilclienterepo;

    //#CREATE
    public boolean create(PerfilCliente perfilCliente) {
        try {
            perfilclienterepo.save(perfilCliente);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(PerfilCliente perfilCliente) {
        try {
            perfilclienterepo.save(perfilCliente);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            perfilclienterepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
