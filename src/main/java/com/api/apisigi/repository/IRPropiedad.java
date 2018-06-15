package com.api.apisigi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.apisigi.entity.Propiedad;

import java.util.Optional;


@Repository("propiedadRepo")
public interface IRPropiedad extends JpaRepository<Propiedad, String> {
    public abstract Optional<Propiedad> findPropiedadByEstadoAndTipopropiedadAndComunaAndOficinaAndCasaAndVentaAndDepartamentoAndEstacionamientoAndArriendoAndPerfilcliente(String idestado, String  idtipoprop, String  idcomuna, String  idoficina, String  idcasa, String  idventa, String  idepto, String  idestacionamiento, String idarriendo, String idperfil);

}
