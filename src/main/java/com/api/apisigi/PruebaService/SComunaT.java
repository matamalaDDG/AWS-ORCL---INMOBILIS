package com.api.apisigi.PruebaService;

import com.api.apisigi.ConverterT.ComunaTConverter;
import com.api.apisigi.PruebaRepository.IRComunaT;
import com.api.apisigi.pruebaEntity.Comuna;
import com.api.apisigi.pruebaModel.MComunaT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("comunaTService")
public class SComunaT {

    @Autowired
    @Qualifier("comunaTRepo")
    private IRComunaT comunaTrepo;

    @Autowired
    @Qualifier("comunaTConverter")
    private ComunaTConverter comunatconverter;

    //#CREATE
    public boolean create(Comuna comuna) {
        try {
            comunaTrepo.save(comuna);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    public List<MComunaT> read() {
        return comunatconverter.listConverter(comunaTrepo.findAll());
    }
}
