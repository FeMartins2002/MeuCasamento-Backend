package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.request.spouse.CreateSpouseDTO;
import br.com.MeuCasamento.entities.Party;
import br.com.MeuCasamento.entities.Spouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SpouseMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "party", source = "party")
    @Mapping(target = "password", source = "defaultPassword")
    Spouse toEntity(CreateSpouseDTO dto, Party party, String defaultPassword);
}
