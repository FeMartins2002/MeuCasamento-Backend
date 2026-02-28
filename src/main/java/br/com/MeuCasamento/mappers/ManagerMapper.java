package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.request.manager.CreateManagerDTO;
import br.com.MeuCasamento.dtos.response.manager.ManagerResponseDTO;
import br.com.MeuCasamento.entities.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "phone", source = "dto.phone")
    @Mapping(target = "cpf", source = "dto.cpf")
    @Mapping(target = "address", source = "dto.address")
    @Mapping(target = "password", source = "defaultPassword")
    Manager toManager(CreateManagerDTO dto, String defaultPassword);

    ManagerResponseDTO toResponse(Manager manager);
}
