package com.example.crud.domain.product;
// Define o pacote onde esta classe está localizada, indicando que pertence ao domínio de "product".

import jakarta.validation.constraints.*;
// Importa a anotação @NotBlank, que é usada para validar que um campo de texto não esteja vazio ou composto apenas por espaços em branco.

// Importa a anotação @NotNull, que é usada para garantir que um campo não seja nulo.

public record RequestProduct (
        // Define uma classe record chamada RequestProduct, que encapsula os dados de entrada para operações relacionadas aos produtos.
        // Records são uma forma concisa de criar classes imutáveis em Java.

        String id,
        // Campo id do produto, que pode ser nulo ou vazio neste caso, já que não há validação adicional definida.

        @NotBlank @Size(max=50) @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
        // Valida que o campo name não esteja vazio ou composto apenas por espaços em branco.
        String name,

        @NotNull @Min(value = 1)
        // Valida que o campo price_in_cents não seja nulo. É usado para garantir que o preço do produto seja fornecido.
        Integer price_in_cents
){
        // O corpo da classe record está vazio, pois records não precisam de construtores ou métodos explícitos para gerenciar os campos.
}
