package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Propiedad;

import java.io.Serializable;
import java.util.Optional;

@Repository("propiedadRepo")
public interface IRPropiedad extends JpaRepository<Propiedad, String> {
    public abstract Optional<Propiedad> findPropiedadByEstadoAndTipopropiedadAndComunaAndOficinaAndCasaAndVentaAndDepartamentoAndEstacionamientoAndArriendoAndPerfilcliente(String idconservador,
                                                                                                                                                                            String idcovenio,
                                                                                                                                                                            String iddocbanco,
                                                                                                                                                                            String iddocnotaria,
                                                                                                                                                                            String idservicio,
                                                                                                                                                                            String idtasacion,
                                                                                                                                                                            String idcorredor,
                                                                                                                                                                            String idperfil);
}
