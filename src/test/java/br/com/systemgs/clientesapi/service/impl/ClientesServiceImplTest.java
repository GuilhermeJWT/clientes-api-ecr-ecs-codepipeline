package br.com.systemgs.clientesapi.service.impl;

import br.com.systemgs.clientesapi.exception.erros.ClienteNaoEncontradoException;
import br.com.systemgs.clientesapi.model.ModelClientes;
import br.com.systemgs.clientesapi.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles(value = "test")
@SpringBootTest
class ClientesServiceImplTest {

    @InjectMocks
    private ClientesServiceImpl clientesServiceImpl;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientesServiceImpl = new ClientesServiceImpl(clienteRepository);
    }

    @Test
    void testPesquisaPorIdClienteEncontrado() {
        ModelClientes cliente = new ModelClientes();
        cliente.setId(1L);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        ModelClientes resultado = clientesServiceImpl.pesquisaPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void testPesquisaPorIdClienteNaoEncontrado() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ClienteNaoEncontradoException.class, () -> clientesServiceImpl.pesquisaPorId(1L));
    }

    @Test
    void testListarClientesComClientes() {
        List<ModelClientes> clientes = List.of(
                new ModelClientes(1L, "Guilherme", "gui@email.com"),
                new ModelClientes(2L, "Guilherme2", "gui2@email.com")
        );
        when(clienteRepository.findAll()).thenReturn(clientes);

        List<ModelClientes> resultado = clientesServiceImpl.listarClientes();

        assertEquals(2, resultado.size());
    }

    @Test
    void testListarClientesSemClientes() {
        when(clienteRepository.findAll()).thenReturn(List.of());

        List<ModelClientes> resultado = clientesServiceImpl.listarClientes();

        assertTrue(resultado.isEmpty());
    }

    @Test
    void testSalvarClientesComSucesso() {
        ModelClientes cliente = new ModelClientes(1L, "Guilherme", "gui@email.com");
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        ModelClientes resultado = clientesServiceImpl.salvarClientes(cliente);

        assertNotNull(resultado);
        assertEquals("Guilherme", resultado.getNome());
    }

    @Test
    void testDeletarClienteComSucesso() {
        Long id = 1L;

        clientesServiceImpl.deletarCliente(id);

        verify(clienteRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeletarClientenaoExistente() {
        doThrow(new IllegalArgumentException("Cliente não Encontrado!")).when(clienteRepository).deleteById(999L);

        assertThrows(IllegalArgumentException.class, () -> clientesServiceImpl.deletarCliente(999L));
    }

}