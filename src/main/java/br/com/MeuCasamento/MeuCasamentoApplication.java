package br.com.MeuCasamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeuCasamentoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MeuCasamentoApplication.class, args);
        System.out.print("Aplicação rodando com sucesso...");
	}
}
