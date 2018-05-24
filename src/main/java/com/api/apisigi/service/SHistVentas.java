package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.HistVentas;
import com.api.apisigi.repository.IRHistVentas;

@Service("histVentasService")
public class SHistVentas {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("histVentasRepo")
    private IRHistVentas histventasRepo;

    //#CREATE
    public boolean create(HistVentas histVentas) {
        try {
            histventasRepo.save(histVentas);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(HistVentas histVentas) {
        try {
            histventasRepo.save(histVentas);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            histventasRepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
