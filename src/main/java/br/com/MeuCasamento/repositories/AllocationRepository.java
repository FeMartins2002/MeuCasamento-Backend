package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Allocation;
import br.com.MeuCasamento.entities.PartyConfig;
import br.com.MeuCasamento.entities.Professional;
import br.com.MeuCasamento.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
    @Query("""
    SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END
    FROM Allocation a
    WHERE a.allocationDateTime = :dateTime
    AND a.allocationValue = :value
    AND a.partyConfig = :partyConfig
    AND a.service = :service
    AND a.professional = :professional
""")
    boolean existsAllocation(
            @Param("dateTime") LocalDateTime dateTime,
            @Param("value") double value,
            @Param("partyConfig") PartyConfig partyConfig,
            @Param("service") Service service,
            @Param("professional") Professional professional
    );
}
