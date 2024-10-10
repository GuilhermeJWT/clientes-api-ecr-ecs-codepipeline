package br.com.systemgs.clientesapi.repository;

import br.com.systemgs.clientesapi.model.ModelClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ModelClientes, Long> {}
