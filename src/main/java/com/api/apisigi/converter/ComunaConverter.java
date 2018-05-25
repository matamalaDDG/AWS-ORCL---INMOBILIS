package com.api.apisigi.converter;

import com.api.apisigi.entity.Comuna;
import com.api.apisigi.model.MComuna;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("comunaConverter")
public class ComunaConverter {
    public List<MComuna> listConverter(List<Comuna> comunas) {
        List<MComuna> mcomuna = new ArrayList<>();
        for (Comuna comuna : comunas) {
            mcomuna.add(new MComuna(comuna));
        }
        return mcomuna;
    }
}
