package br.com.systemgs.clientesapi.service.impl;

import br.com.systemgs.clientesapi.exception.erros.ClienteNaoEncontradoException;
import br.com.systemgs.clientesapi.model.ModelClientes;
import br.com.systemgs.clientesapi.repository.ClienteRepository;
import br.com.systemgs.clientesapi.service.ClientesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    private final ClienteRepository clienteRepository;

    public ClientesServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ModelClientes pesquisaPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(ClienteNaoEncontradoException::new);
    }

    @Override
    public List<ModelClientes> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ModelClientes salvarClientes(ModelClientes modelClientes) {
        return clienteRepository.save(modelClientes);
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
