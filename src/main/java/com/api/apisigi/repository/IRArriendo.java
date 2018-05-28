package com.api.apisigi.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import com.api.apisigi.entity.Arriendo;

        import java.io.Serializable;
        import java.sql.Time;
        import java.util.List;
        import java.util.Optional;

@Repository("arriendoRepo")
public interface IRArriendo extends JpaRepository<Arriendo, String> {
    public abstract Optional<Arriendo> findArriendoByAseguradoraAndPrecontratoAndCapacidadeconomicaAndConvenioAndCorredor(String precontratoid,String aseguradoraid,String capacidadeconomicaid,String convenioid,String corredorid);

}
