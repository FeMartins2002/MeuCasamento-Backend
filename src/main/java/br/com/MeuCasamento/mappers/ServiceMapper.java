package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.request.service.CreateServiceDTO;
import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.entities.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "type", source = "dto.type")
    @Mapping(target = "serviceValue", source = "dto.serviceValue")
    @Mapping(target = "allocations", ignore = true)
    @Mapping(target = "serviceConfig", ignore = true)
    @Mapping(target = "manager", source = "manager")
    Service toEntity(CreateServiceDTO dto, Manager manager);
}
