package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GiftRepository extends JpaRepository<Gift, Long> {
    Gift findByName(String name);

    @Query("""
    SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END
    FROM Gift g
    WHERE g.name = :name
    AND g.price = :price
    AND g.store = :store
    AND g.giftList.id = :giftListId
""")
    boolean existsGift(
            @Param("name") String name,
            @Param("price") double price,
            @Param("store") String store,
            @Param("id") Long id
    );
}
