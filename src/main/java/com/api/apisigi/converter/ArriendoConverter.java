package com.api.apisigi.converter;

import org.springframework.stereotype.Component;
import com.api.apisigi.entity.Arriendo;
import com.api.apisigi.model.MArriendo;

import java.util.ArrayList;
import java.util.List;

@Component("arriendoConverter")
public class ArriendoConverter {

    public List<MArriendo> listConverter(List<Arriendo> arriendos) {
        List<MArriendo> mArriendo = new ArrayList<>();
        for (Arriendo arriendo : arriendos) {
            mArriendo.add(new MArriendo(arriendo));
        }
        return mArriendo;
    }
}
