package com.example.crud.domain.product;
// Define o pacote onde a classe Product está localizada.
// "domain.product" sugere que esta classe é parte da lógica de domínio referente a produtos.

import jakarta.persistence.*;
// Importa as anotações do JPA (Java Persistence API) usadas para mapear a classe como uma entidade no banco de dados.

import lombok.*;
// Importa anotações do Lombok, que são usadas para gerar automaticamente código comum, como getters, setters e construtores.

import org.springframework.boot.autoconfigure.web.WebProperties;
// Esta importação parece não estar sendo usada no código. Você pode removê-la se não for necessária para manter o código limpo.

@Table(name = "product")
// Especifica o nome da tabela no banco de dados que será mapeada por esta entidade. Aqui, a tabela será chamada "product".

@Entity(name = "product")
// Define que esta classe é uma entidade JPA, ou seja, ela será mapeada para uma tabela no banco de dados.
// O parâmetro "name" define como essa entidade será referenciada em consultas JPQL.

@Getter
@Setter
// Gera automaticamente os métodos getters e setters para todos os campos da classe (Lombok).

@AllArgsConstructor
// Gera um construtor que inclui todos os campos como parâmetros (Lombok).

@NoArgsConstructor
// Gera um construtor vazio (sem parâmetros) necessário para uso em frameworks como JPA (Lombok).

@EqualsAndHashCode(of = "id")
// Gera automaticamente métodos equals e hashCode, baseados no campo "id", garantindo que a comparação de objetos considere apenas o ID (Lombok).

public class Product {
    // Define a classe Product, que é uma representação de um produto no sistema.

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    // Especifica que o campo "id" é a chave primária da entidade e será gerado automaticamente como um UUID (Universal Unique Identifier).
    private String id;

    private String name;
    // Campo que representa o nome do produto. Não possui mapeamento adicional, então será uma coluna padrão.

    private Integer price_in_cents;
    // Campo que representa o preço do produto, armazenado em centavos para evitar problemas com ponto flutuante.

    public Product(RequestProduct requestProduct) {
        // Construtor personalizado que cria um objeto Product com base em um RequestProduct (provavelmente usado para mapeamento de requisições HTTP).
        this.name = requestProduct.name();
        // Define o nome com base no objeto RequestProduct.
        this.price_in_cents = requestProduct.price_in_cents();
        // Define o preço com base no objeto RequestProduct.
    }
}
