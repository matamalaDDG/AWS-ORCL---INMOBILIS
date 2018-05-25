package com.api.apisigi.ConverterT;

import com.api.apisigi.pruebaEntity.Comuna;
import com.api.apisigi.pruebaModel.MComunaT;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("comunaTConverter")
public class ComunaTConverter {
    public List<MComunaT> listConverter(List<Comuna> comunas) {
        List<MComunaT> mTregion = new ArrayList<>();
        for (Comuna comuna : comunas) {
            mTregion.add(new MComunaT(comuna));
        }
        return mTregion;
    }
}
