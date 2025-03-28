package com.example.crud.exception;

// Importações necessárias para gerenciar status HTTP, respostas, exceções e validações.
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice
// A anotação @RestControllerAdvice transforma esta classe em um manipulador global de exceções
// para controladores REST. Isso permite interceptar e tratar exceções específicas.
public class GlobalExceptionHandler {

    @ExceptionHandler
    // O metodo abaixo é designado para lidar com a exceção MethodArgumentNotValidException,
    // que ocorre quando validações em objetos, como @Valid em @RequestBody, falham.
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Cria um mapa para armazenar os campos inválidos e suas mensagens de erro correspondentes.
        Map<String, String> errors = new HashMap<>();

        // Itera pela lista de erros de validação de campos e preenche o mapa com o campo como chave
        // e a mensagem de erro como valor.
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        // Retorna uma resposta HTTP com status 400 (BAD REQUEST) e o corpo contendo o mapa de erros.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(Exception.class)
    // Este método captura qualquer exceção genérica (Exception) que não seja tratada
    // por handlers mais específicos. Serve como um fallback para erros não previstos.
    public ResponseEntity<String> handleGeneralExceptions(Exception ex) {
        // Retorna uma resposta HTTP com status 500 (INTERNAL SERVER ERROR),
        // juntamente com uma mensagem de erro genérica e a mensagem da exceção.
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno: " + ex.getMessage());
    }
}
