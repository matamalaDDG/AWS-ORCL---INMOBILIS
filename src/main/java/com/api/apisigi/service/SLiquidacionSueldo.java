package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.LiquidacionSueldo;
import com.api.apisigi.repository.IRLiquidacionSueldo;

@Service("liquidacionSueldoService")
public class SLiquidacionSueldo {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("liquidacionSueldoRepo")
    private IRLiquidacionSueldo liquidacionSueldorepo;

    //#CREATE
    public boolean create(LiquidacionSueldo histVentas) {
        try {
            liquidacionSueldorepo.save(histVentas);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    //  public List<sadsa> read(){return sadsa;}
    //#UPDATE
    public boolean update(LiquidacionSueldo histVentas) {
        try {
            liquidacionSueldorepo.save(histVentas);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            liquidacionSueldorepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
