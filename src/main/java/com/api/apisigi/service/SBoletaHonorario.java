package com.api.apisigi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("boletahonorarioService")
public class SBoletaHonorario {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    //#CREATE
    public boolean create() {
        try {
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    //#READ
    //public List<MBoletaHonorario> read(){}
    //#UPDATE
    public boolean update() {
        try {
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete() {
        try {
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
