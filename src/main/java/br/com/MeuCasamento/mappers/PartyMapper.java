package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.request.party.CreatePartyDTO;
import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.entities.Party;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PartyMapper {
    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "date", source = "dto.partyDate")
    @Mapping(target = "manager", source = "manager")
    Party toEntity(CreatePartyDTO dto, Manager manager);
}
