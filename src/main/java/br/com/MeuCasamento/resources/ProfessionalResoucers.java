package br.com.MeuCasamento.resources;

import br.com.MeuCasamento.dtos.request.professional.CreateProfessionalDTO;
import br.com.MeuCasamento.dtos.response.professional.ProfessionalResponseDTO;
import br.com.MeuCasamento.services.ProfessionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meucasamento/professional")
public class ProfessionalResoucers {
    @Autowired
    private ProfessionalService professionalService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateProfessionalDTO createProfessionalDTO) {
        ProfessionalResponseDTO response = professionalService.save(createProfessionalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
