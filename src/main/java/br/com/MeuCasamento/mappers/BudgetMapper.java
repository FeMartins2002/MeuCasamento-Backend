package br.com.MeuCasamento.mappers;

import br.com.MeuCasamento.dtos.response.budget.BudgetResponseDTO;
import br.com.MeuCasamento.entities.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetMapper {
    @Mapping(target = "id", ignore = true)
    BudgetResponseDTO toResponse(Budget budget);
}
