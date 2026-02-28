package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service,Long> {

    @Query("""
    SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END
    FROM Service s
    WHERE s.name = :name
    AND s.type = :type
    AND s.serviceValue = :serviceValue
""")
    boolean existsService(
            @Param("name") String name,
            @Param("type") String type,
            @Param("serviceValue") double serviceValue
    );
}
