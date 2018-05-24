package com.api.apisigi.converter;

import com.api.apisigi.entity.Region;
import com.api.apisigi.model.MRegion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component("regionConverter")
public class RegionConverter {

    public List<MRegion> listConverter(List<Region> regiones) {
        List<MRegion> mregion = new ArrayList<>();
        for (Region region : regiones) {
            mregion.add(new MRegion(region));
        }
        return mregion;
    }
}
