package com.example.crud.controllers;

import com.example.crud.domain.product.Product;
import com.example.crud.dto.ProductDTO;
import com.example.crud.domain.product.ProductRepository;
import com.example.crud.domain.product.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/product")

public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductoById(@PathVariable String id){
        var product = repository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //metodo para retornar todos os produtos

    @GetMapping
    public ResponseEntity getAllProduct() {
        var allproducts = repository.findAll();
        return ResponseEntity.ok(allproducts);

    }

    @PostMapping
    public ResponseEntity registreProduct(@RequestBody @Valid RequestProduct data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        System.out.println(data);
        return ResponseEntity.ok().build();
    }


    @PutMapping (produces = "application/json")
    public ResponseEntity <ProductDTO>updateProduct(@RequestBody @Valid RequestProduct data) {
        Product product = repository.getReferenceById(data.id());
        product.setName(data.name());
        product.setPrice_in_cents(data.price_in_cents());
        repository.save(product);

        ProductDTO dto = new ProductDTO (product.getId(), product.getName(), product.getPrice_in_cents());
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deleteProduct (@PathVariable String id ){

            if (repository.existsById(id)){
                repository.deleteById(id);
                return ResponseEntity.noContent().build();
        } else {
                return ResponseEntity.notFound().build();
            }
        }

}
