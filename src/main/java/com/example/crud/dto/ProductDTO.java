package com.example.crud.dto;
// Define o pacote onde esta classe está localizada. O pacote "dto" (Data Transfer Object) é usado para classes que transferem dados entre camadas do sistema.

public class ProductDTO {
    // Declara a classe ProductDTO. DTO (Data Transfer Object) é usado para encapsular e transferir informações entre o servidor e o cliente sem expor a entidade original diretamente.

    private String id;
    // Define o campo "id", que representa o identificador único do produto.

    private String name;
    // Define o campo "name", que representa o nome do produto.

    private Integer
            price_in_cents;
    // Define o campo "price_in_cents", que armazena o preço do produto em centavos, uma prática comum para evitar problemas com números decimais em cálculos financeiros.

    public ProductDTO(String id, String name, Integer price_in_cents) {
        // Construtor da classe ProductDTO. Inicializa os campos da classe com os valores fornecidos como parâmetros.
        this.id = id;
        // Atribui o valor do parâmetro "id" ao campo "id" da classe.
        this.name = name;
        // Atribui o valor do parâmetro "name" ao campo "name" da classe.
        this.price_in_cents = price_in_cents;
        // Atribui o valor do parâmetro "price_in_cents" ao campo "price_in_cents" da classe.
    }

    // Getters
    // Métodos que permitem acessar os valores dos campos da classe, seguindo a convenção de encapsulamento.

    public String getId() {
        // Retorna o valor do campo "id".
        return id;
    }

    public String getName() {
        // Retorna o valor do campo "name".
        return name;
    }

    public Integer getPrice_in_cents() {
        // Retorna o valor do campo "price_in_cents".
        return price_in_cents;
    }
}
