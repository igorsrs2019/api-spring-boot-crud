package com.example.crud;
// Define o pacote onde esta classe está localizada. Isso organiza o código e ajuda a evitar conflitos de nomes entre diferentes classes em outros pacotes.

import org.springframework.boot.builder.SpringApplicationBuilder;
// Importa a classe SpringApplicationBuilder, que é usada para construir e configurar o contexto da aplicação Spring Boot quando rodamos em servidores externos como Tomcat.

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// Importa SpringBootServletInitializer, que serve como uma classe de inicialização para configurar aplicações Spring Boot que serão implantadas como arquivos WAR em contêineres de servlet.

public class ServletInitializer extends SpringBootServletInitializer {
	// Declara a classe ServletInitializer que estende SpringBootServletInitializer.
	// É usada para configurar a aplicação Spring Boot em ambientes onde a aplicação precisa rodar em contêineres de servlet (como servidores externos Apache Tomcat, Jetty, etc.).

	@Override
	// Indica que estamos sobrescrevendo o método `configure` definido na classe base SpringBootServletInitializer.

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// Método `configure` é utilizado para customizar o contexto de inicialização do Spring Boot.
		// Ele ajusta como a aplicação será inicializada em contêineres de servlet.
		return application.sources(CrudApplication.class);
		// Define a classe principal da aplicação (CrudApplication) como a fonte de configuração para o contexto Spring.
		// Essencialmente, estamos informando ao contêiner qual classe é responsável por iniciar a aplicação.
	}
}
