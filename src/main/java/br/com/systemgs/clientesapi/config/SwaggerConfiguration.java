package br.com.systemgs.clientesapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Clientes Api", version = "1.0.0",
        description = "Projeto Simples utilizando - AWS: ECR, ECS, CODE (Build, Deploy, Pipeline)"))
public class SwaggerConfiguration {}
