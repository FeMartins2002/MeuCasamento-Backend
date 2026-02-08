package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.request.guest.CreateGuestDTO;
import br.com.MeuCasamento.entities.Guest;
import br.com.MeuCasamento.entities.GuestList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GuestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "guestList", source = "guestList")
    Guest toEntity(CreateGuestDTO dto, GuestList guestList);
}
