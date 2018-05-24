package com.api.apisigi.converter;

import org.springframework.stereotype.Component;
import com.api.apisigi.entity.Aseguradora;
import com.api.apisigi.model.MAseguradora;

import java.util.ArrayList;
import java.util.List;

@Component("aseguradoraConverter")
public class AseguradoraConverter {

    public List<MAseguradora> listConverter(List<Aseguradora> aseguradoras) {
        List<MAseguradora> mAseguradora = new ArrayList<>();
        for (Aseguradora aseguradora : aseguradoras) {
            mAseguradora.add(new MAseguradora(aseguradora));
        }
        return mAseguradora;
    }
}
