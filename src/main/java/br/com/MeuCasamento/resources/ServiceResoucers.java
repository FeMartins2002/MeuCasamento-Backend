package br.com.MeuCasamento.resources;

import br.com.MeuCasamento.dtos.request.service.CreateServiceDTO;
import br.com.MeuCasamento.dtos.response.service.ServiceResponseDTO;
import br.com.MeuCasamento.services.WeddingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meucasamento/service")
public class ServiceResoucers {
    @Autowired
    private WeddingService weddingService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateServiceDTO createServiceDTO) {
        ServiceResponseDTO response = weddingService.save(createServiceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
