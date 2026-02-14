package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByEmail(String email);

    @Query("""
    SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END
    FROM Guest g
    WHERE g.name = :name
    AND g.phone = :phone
    AND g.email = :email
    AND g.address = :address
    AND g.guestList.id = :guestListId
""")
    boolean existsGuest(
            @Param("name") String name,
            @Param("phone") String phone,
            @Param("email") String email,
            @Param("address") String address,
            @Param("guestListId") Long guestListId
    );

}
