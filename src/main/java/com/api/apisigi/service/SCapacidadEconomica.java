package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.CapacidadEconomica;
import com.api.apisigi.repository.IRCapacidadEconomica;

@Service("capacidadeconomicaServices")
public class SCapacidadEconomica {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("capacidadEconomicaRepo")
    private IRCapacidadEconomica capacidadEconomicarepo;

    //#CREATE
    public boolean create(CapacidadEconomica capacidadeconomica) {
        try {

            capacidadEconomicarepo.save(capacidadeconomica);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    //#READ
    //public List<MBoletaHonorario> read(){}
    //#UPDATE
    public boolean update(CapacidadEconomica capacidadEconomica) {
        try {
            capacidadEconomicarepo.save(capacidadEconomica);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            capacidadEconomicarepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
