package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.request.partyhall.CreatePartyHallDTO;
import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.entities.PartyHall;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PartyHallMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "address", source = "dto.address")
    @Mapping(target = "availability", source = "dto.availability")
    @Mapping(target = "manager", source = "manager")
    PartyHall toEntity(CreatePartyHallDTO dto, Manager manager);
}
