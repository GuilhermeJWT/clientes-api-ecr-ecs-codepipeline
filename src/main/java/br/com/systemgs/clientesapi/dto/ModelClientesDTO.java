package br.com.systemgs.clientesapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ModelClientesDTO(

        Long id,

        @NotBlank(message = "Nome Obrigatório.")
        String nome, @NotBlank(message = "Nome Obrigatório.")

        @Email(message = "Formato de E-mail Inválido.")
        @NotBlank(message = "E-mail Obrigatório.")
        String email)

        {}
