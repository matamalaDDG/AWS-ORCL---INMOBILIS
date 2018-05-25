package com.api.apisigi.PruebaService;

import com.api.apisigi.ConverterT.RegionTConverter;
import com.api.apisigi.PruebaRepository.IRRegionT;
import com.api.apisigi.converter.RegionConverter;
import com.api.apisigi.pruebaEntity.Region;
import com.api.apisigi.pruebaModel.MRegionT;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("regionTService")
public class SRegionT {
    //#ACTIVADO LOGS EN SISTEMA
    public static final Log logger = LogFactory.getLog(SRegionT.class);

    @Autowired
    @Qualifier("regionTRepo")
    private IRRegionT regionTrepo;

    @Autowired
    @Qualifier("regionTConverter")
    private RegionTConverter regionconverter;

    //#CREATE
    public boolean create(Region region) {
        try {
            regionTrepo.save(region);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //#READ
    public List<MRegionT> read() {
        return regionconverter.listConverter(regionTrepo.findAll());
    }
}
