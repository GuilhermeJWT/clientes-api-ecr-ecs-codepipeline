package br.com.systemgs.clientesapi.controller;

import br.com.systemgs.clientesapi.model.ModelClientes;
import br.com.systemgs.clientesapi.service.ClientesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles(value = "test")
@SpringBootTest
class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClientesService clientesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteController = new ClienteController(clientesService);
    }

    @Test
    void testPesquisaPorIdSuccesso() {
        ModelClientes cliente = new ModelClientes();
        cliente.setId(1L);
        cliente.setNome("Guilherme");
        cliente.setEmail("gui@email.com");

        when(clientesService.pesquisaPorId(1L)).thenReturn(cliente);

        ResponseEntity<ModelClientes> response = clienteController.pesquisaPorId(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(cliente, response.getBody());
    }

    @Test
    void testListarClientesSuccesso() {
        List<ModelClientes> clientes = List.of(
                new ModelClientes(1L, "Guilherme", "gui@email.com"),
                new ModelClientes(2L, "Guilherme2", "gui2@email.com")
        );

        when(clientesService.listarClientes()).thenReturn(clientes);

        ResponseEntity<List<ModelClientes>> response = clienteController.listarClientes();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(clientes.size(), response.getBody().size());
    }

    @Test
    void testListarClientesEmptyList() {
        when(clientesService.listarClientes()).thenReturn(List.of());

        ResponseEntity<List<ModelClientes>> response = clienteController.listarClientes();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }

    @Test
    void testSalvarClienteSuccesso() {
        ModelClientes cliente = new ModelClientes();
        cliente.setId(1L);
        cliente.setNome("Guilherme");
        cliente.setEmail("gui@email.com");

        when(clientesService.salvarClientes(cliente)).thenReturn(cliente);

        ResponseEntity<ModelClientes> response = clienteController.salvarCliente(cliente);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(cliente, response.getBody());
    }

    @Test
    void testDeletarCliente_Success() {
        Long id = 1L;

        clienteController.deletarCliente(id);

        verify(clientesService, times(1)).deletarCliente(id);
    }
}