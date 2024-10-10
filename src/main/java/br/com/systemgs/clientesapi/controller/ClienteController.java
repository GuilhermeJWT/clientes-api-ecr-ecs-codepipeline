package br.com.systemgs.clientesapi.controller;

import br.com.systemgs.clientesapi.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClientesService clientesService;

    @Autowired
    public ClienteController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<Model>

}
