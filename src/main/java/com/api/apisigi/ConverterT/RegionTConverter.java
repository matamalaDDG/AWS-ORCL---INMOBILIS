package com.api.apisigi.ConverterT;

import com.api.apisigi.pruebaEntity.Region;
import com.api.apisigi.pruebaModel.MRegionT;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("regionTConverter")
public class RegionTConverter {

    public List<MRegionT> listConverter(List<Region> regiones) {
        List<MRegionT> mTregion = new ArrayList<>();
        for (Region region : regiones) {
            mTregion.add(new MRegionT(region));
        }
        return mTregion;
    }
}
