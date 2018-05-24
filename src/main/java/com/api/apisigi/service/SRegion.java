package com.api.apisigi.service;

import com.api.apisigi.converter.RegionConverter;
import com.api.apisigi.model.MRegion;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.api.apisigi.entity.Region;
import com.api.apisigi.repository.IRRegion;

import java.util.List;

@Service("regionService")
public class SRegion {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SArriendo.class);

    @Autowired
    @Qualifier("regionRepo")
    private IRRegion regionrepo;
    @Autowired
    @Qualifier("regionConverter")
    private RegionConverter regionconverter;

    //#CREATE
    public boolean create(Region region) {
        try {
            regionrepo.save(region);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    public List<MRegion> read() {
        return regionconverter.listConverter(regionrepo.findAll());
    }

    //#UPDATE
    public boolean update(Region region) {
        try {
            regionrepo.save(region);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#DELETE
    public boolean delete(String id) {
        try {
            regionrepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
