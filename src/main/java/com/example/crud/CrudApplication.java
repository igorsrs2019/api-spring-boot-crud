package com.example.crud;
// Define o pacote onde esta classe está localizada. Isso organiza o código e evita conflitos de nomes entre classes de outros pacotes.
// "com.example.crud" sugere que o projeto é um sistema CRUD (Create, Read, Update, Delete).

import org.springframework.boot.SpringApplication;
// Importa a classe SpringApplication, responsável por inicializar e executar o aplicativo Spring Boot.
// Essa classe contém métodos úteis para configurar o ambiente Spring e iniciar o servidor.

import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importa a anotação @SpringBootApplication, usada para habilitar várias configurações do Spring Boot automaticamente.
// Essa anotação combina três importantes funcionalidades: @Configuration, @EnableAutoConfiguration e @ComponentScan.

@SpringBootApplication
// Marca esta classe como a principal classe de configuração do aplicativo Spring Boot.
// Habilita a configuração automática do aplicativo com base nas dependências do projeto.
// Faz o escaneamento de componentes em pacotes para registrar beans e criar o contexto da aplicação.

public class CrudApplication {
	// Declara a classe principal do projeto. Por convenção, esta classe contém o método `main`, que inicia o aplicativo.

	public static void main(String[] args) {
		// Define o método main como o ponto de entrada do aplicativo.
		SpringApplication.run(CrudApplication.class, args);
		// Inicializa o Spring Application Context, que configura todos os componentes necessários para executar o aplicativo.
		// Também inicia o servidor embutido (como Tomcat), tornando os endpoints disponíveis para serem acessados.
	}
}
