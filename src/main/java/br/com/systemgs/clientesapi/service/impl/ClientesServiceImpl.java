package br.com.systemgs.clientesapi.service.impl;

import br.com.systemgs.clientesapi.dto.ModelClientesDTO;
import br.com.systemgs.clientesapi.exception.erros.ClienteNaoEncontradoException;
import br.com.systemgs.clientesapi.model.ModelClientes;
import br.com.systemgs.clientesapi.repository.ClienteRepository;
import br.com.systemgs.clientesapi.service.ClientesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper mapper;

    @Autowired
    public ClientesServiceImpl(ClienteRepository clienteRepository, ModelMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
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
    public ModelClientes salvarClientes(ModelClientesDTO modelClientesDTO) {
        return clienteRepository.save(mapper.map(modelClientesDTO, ModelClientes.class));
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
