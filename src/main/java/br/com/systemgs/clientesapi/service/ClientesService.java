package br.com.systemgs.clientesapi.service;

import br.com.systemgs.clientesapi.dto.ModelClientesDTO;
import br.com.systemgs.clientesapi.model.ModelClientes;

import java.util.List;

public interface ClientesService {

    ModelClientes pesquisaPorId(Long id);

    List<ModelClientes> listarClientes();

    ModelClientes salvarClientes(ModelClientesDTO modelClientesDTO);

    void deletarCliente(Long id);

}
