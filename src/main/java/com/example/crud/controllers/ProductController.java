package com.example.crud.controllers;
// Define o pacote onde esta classe está localizada.

import com.example.crud.domain.product.Product;
// Importa a classe Product, que é a entidade representando o produto no domínio.

import com.example.crud.dto.ProductDTO;
// Importa o DTO (Data Transfer Object) usado para transferir dados do produto entre a API e o cliente.

import com.example.crud.domain.product.ProductRepository;
// Importa o repositório de produtos, que é a interface responsável pelas operações no banco de dados.

import com.example.crud.domain.product.RequestProduct;
// Importa uma classe que encapsula os dados da requisição para criar ou atualizar um produto.

import jakarta.validation.Valid;
// Importa a anotação @Valid, usada para garantir que as entradas da requisição sejam validadas de acordo com as restrições definidas.

import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação @Autowired para injetar automaticamente dependências no controlador.

import org.springframework.http.ResponseEntity;
// Importa a classe ResponseEntity, usada para construir respostas HTTP com código de status e corpo.

import org.springframework.web.bind.annotation.*;
// Importa anotações como @RestController, @GetMapping, @PostMapping, @PutMapping e @DeleteMapping para mapeamento de requisições HTTP.

@RestController
// Indica que esta classe é um controlador REST. Os métodos desta classe retornam diretamente objetos como JSON.






@RequestMapping("/product")
// Define o caminho base para todos os endpoints desta classe, ou seja, todas as rotas começarão com /product.

public class ProductController {
    @Autowired
    // Injeta automaticamente uma instância do ProductRepository nesta classe.
    private ProductRepository repository;

    @GetMapping("/{id}")
    // Mapeia requisições HTTP GET para o endpoint /product/{id}. O {id} é um parâmetro dinâmico na URL.
    public ResponseEntity<Product> getProductoById(@PathVariable String id) {
        // Declaração do método para buscar um produto específico pelo ID fornecido.
        var product = repository.findById(id);
        // Busca o produto no banco de dados usando o repositório. Retorna um Optional<Product>.
        if (product.isPresent()) {
            // Se o produto foi encontrado, retorna o produto com o status HTTP 200 (OK).
            return ResponseEntity.ok(product.get());
        } else {
            // Se o produto não foi encontrado, retorna o status HTTP 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }

    // Método para retornar todos os produtos.
    @GetMapping
    // Mapeia requisições HTTP GET para o endpoint /product.
    public ResponseEntity getAllProduct() {
        var allproducts = repository.findAll();
        // Busca todos os produtos no banco de dados.
        return ResponseEntity.ok(allproducts);
        // Retorna a lista de produtos com o status HTTP 200 (OK).
    }

    @PostMapping
    // Mapeia requisições HTTP POST para o endpoint /product.
    public ResponseEntity registreProduct(@RequestBody @Valid RequestProduct data) {
        // Declaração do método para criar um novo produto. A anotação @RequestBody indica que os dados virão no corpo da requisição.
        // A anotação @Valid garante que o objeto RequestProduct seja validado.
        Product newProduct = new Product(data);
        // Cria uma nova instância de Product com base nos dados fornecidos na requisição.
        repository.save(newProduct);
        // Salva o novo produto no banco de dados.
        System.out.println(data);
        // Imprime os dados recebidos no console (apenas para debug).
        return ResponseEntity.ok().build();
        // Retorna uma resposta com status HTTP 200 (OK), mas sem corpo.
    }

    @PutMapping(produces = "application/json")
    // Mapeia requisições HTTP PUT para o endpoint /product e especifica que a resposta será no formato JSON.
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody @Valid RequestProduct data) {
        // Declaração do método para atualizar um produto existente.
        Product product = repository.getReferenceById(data.id());
        // Obtém uma referência ao produto pelo ID fornecido.
        product.setName(data.name());
        // Atualiza o nome do produto.
        product.setPrice_in_cents(data.price_in_cents());
        // Atualiza o preço do produto.
        repository.save(product);
        // Salva as alterações no banco de dados.
        ProductDTO dto = new ProductDTO(product.getId(), product.getName(), product.getPrice_in_cents());
        // Cria um DTO (Data Transfer Object) com os dados atualizados do produto.
        return ResponseEntity.ok(dto);
        // Retorna o DTO atualizado com o status HTTP 200 (OK).
    }

    @DeleteMapping("/{id}")
    // Mapeia requisições HTTP DELETE para o endpoint /product/{id}.
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        // Declaração do método para excluir um produto com base no ID fornecido.
        if (repository.existsById(id)) {
            // Verifica se existe um produto com o ID fornecido.
            repository.deleteById(id);
            // Exclui o produto do banco de dados.
            return ResponseEntity.noContent().build();
            // Retorna o status HTTP 204 (No Content) para indicar exclusão bem-sucedida.
        } else {
            // Se o produto com o ID fornecido não existe, retorna o status HTTP 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }
}
