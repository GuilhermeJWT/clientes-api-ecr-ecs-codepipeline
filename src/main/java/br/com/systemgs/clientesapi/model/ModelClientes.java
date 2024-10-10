package br.com.systemgs.clientesapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_clientes")
public class ModelClientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome Obrigatório.")
    @Column(name = "nome", length = 100)
    private String nome;

    @Email(message = "E-mail Inválido.")
    @NotBlank(message = "E-mail Obrigatório.")
    @Column(name = "email", unique = true, length = 100)
    private String email;

}
