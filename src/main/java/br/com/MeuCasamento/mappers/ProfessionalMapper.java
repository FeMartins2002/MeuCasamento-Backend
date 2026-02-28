package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.request.professional.CreateProfessionalDTO;
import br.com.MeuCasamento.dtos.response.professional.ProfessionalResponseDTO;
import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.entities.Professional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessionalMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf", source = "dto.cpf")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "phone", source = "dto.phone")
    @Mapping(target = "speciality", source = "dto.speciality")
    @Mapping(target = "availability", source = "dto.availability")
    @Mapping(target = "hourlyRate", source = "dto.hourlyRate")
    @Mapping(target = "manager", source = "manager")
    @Mapping(target = "allocations", ignore = true)
    Professional toEntity(CreateProfessionalDTO dto, Manager manager);

    ProfessionalResponseDTO toResponse(Professional professional);
}
