package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.request.allocation.CreateAllocationDTO;
import br.com.MeuCasamento.entities.Allocation;
import br.com.MeuCasamento.entities.PartyConfig;
import br.com.MeuCasamento.entities.Professional;
import br.com.MeuCasamento.entities.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AllocationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "partyConfig", source = "partyConfig")
    @Mapping(target = "service", source = "service")
    @Mapping(target = "professional", source = "professional")
    Allocation toEntity(CreateAllocationDTO dto, PartyConfig partyConfig, Service service, Professional professional);
}
