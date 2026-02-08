package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.request.gift.CreateGiftDTO;
import br.com.MeuCasamento.entities.Gift;
import br.com.MeuCasamento.entities.GiftList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GiftMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "giftList", source = "giftList")
    Gift toEntity(CreateGiftDTO dto, GiftList giftList);
}
