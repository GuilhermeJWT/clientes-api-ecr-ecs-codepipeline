package br.com.systemgs.clientesapi.controller;

import br.com.systemgs.clientesapi.model.ModelClientes;
import br.com.systemgs.clientesapi.service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClientesService clientesService;

    @Autowired
    public ClienteController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ModelClientes> pesquisaPorId(@PathVariable Long id){
        return ResponseEntity.ok(clientesService.pesquisaPorId(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ModelClientes>> listarClientes(){
        return ResponseEntity.ok(clientesService.listarClientes());
    }

    @PostMapping("/salvar")
    public ResponseEntity<ModelClientes> salvarCliente(@RequestBody @Valid ModelClientes modelClientes){
        ModelClientes clienteSalvo = clientesService.salvarClientes(modelClientes);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(clientesService.pesquisaPorId(clienteSalvo.getId())).toUri();

        return ResponseEntity.created(uri).body(clienteSalvo);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCliente(@PathVariable Long id){
        clientesService.deletarCliente(id);
    }
}
