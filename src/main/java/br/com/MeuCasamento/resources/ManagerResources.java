package br.com.MeuCasamento.resources;

import br.com.MeuCasamento.dtos.request.manager.LoginManagerDTO;
import br.com.MeuCasamento.services.ManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meucasamento/manager")
public class ManagerResources {
    @Autowired
    private ManagerService managerService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginManagerDTO loginManagerDTO) {
        boolean loginValid = managerService.login(loginManagerDTO);

        if (loginValid) {
            return ResponseEntity.ok().body("Login realizado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Email ou senha inválidos");
    }
}
