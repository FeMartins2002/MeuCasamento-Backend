package br.com.MeuCasamento.resources;

import br.com.MeuCasamento.dtos.request.spouse.CreateSpouseDTO;
import br.com.MeuCasamento.dtos.request.spouse.LoginSpouseDTO;
import br.com.MeuCasamento.dtos.response.spouse.SpouseResponseDTO;
import br.com.MeuCasamento.services.SpouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("meucasamento/spouse")
public class SpouseResources {
    @Autowired
    private SpouseService spouseService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginSpouseDTO loginSpouseDTO) {
        boolean loginValid = spouseService.login(loginSpouseDTO);

        if(loginValid) {
            return ResponseEntity.ok().body("Login realizado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateSpouseDTO createSpouseDTO) {
        SpouseResponseDTO response = spouseService.save(createSpouseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
