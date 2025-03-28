package com.example.crud.domain.product;
// Define o pacote onde essa interface está localizada, indicando que pertence ao domínio de "product".

import org.springframework.data.jpa.repository.JpaRepository;
// Importa a interface JpaRepository, que fornece métodos padrão para operações no banco de dados.

public interface ProductRepository extends JpaRepository<Product, String> {
    // Declara a interface ProductRepository, que herda de JpaRepository.
    // A classe Product será a entidade gerenciada pelo repositório, e String será o tipo da chave primária (id).

    // A interface JpaRepository fornece métodos padrão como:
    // - findById(String id): Busca um registro pelo ID.
    // - save(Product product): Salva ou atualiza um registro no banco de dados.
    // - deleteById(String id): Remove um registro pelo ID.
    // - findAll(): Retorna todos os registros da tabela.
    // Além disso, você pode definir consultas personalizadas aqui, se necessário.
}
