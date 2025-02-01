package br.com.igorgabriel.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/*
 * @RequestMapping é uma anotação do Spring Framework usada para mapear requisições HTTP 
 * para métodos de controllers em aplicações Java com Spring Boot. 
 * Ela pode ser aplicada a classes e métodos para definir rotas e comportamentos específicos para requisições HTTP.
 */

 /*
 * @RestController é uma a classe do tipo controller do Spring Framework usada para mapear requisições HTTP
 * para métodos de controllers em aplicações Java com Spring Boot.
 */

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {
    
    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id) {

        return "Primeiro método da primeira controller com id: " + id;
    }

    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id) {
        return "Primeiro método da primeira controller com id: " + id;
    }

    @GetMapping("/metodoComQueryParamsMap")
    public String metodoComQueryParamsMap(@RequestParam Map<String, String> allParams) {
        return "Primeiro método da primeira controller com id: " + allParams.entrySet();
    }


    record Usuario(String nome) {}

    @PostMapping("/metodoComBodyParams")
    public String postMethodName(@RequestBody Usuario usuario) {      
        return "Metodo com body: " + usuario.nome;
    }

    @PostMapping("/metodoComHeaders")
    public String postMetohHeaders(@RequestHeader("nome") String nome) {      
        return "Metodo com body: " + nome;
    }

    @PostMapping("/metodoComListHeaders")
    public String postMethodListHeaders(@RequestHeader Map<String, String> headers) {      
        return "Metodo com body: " + headers.entrySet();
    }

    @GetMapping("metodoResponseEntity")
    public ResponseEntity<Object> metodoResponseEntity() {
        // ResponseEntity<String> response = new ResponseEntity<String>("Hello World", HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Mensagem de erro");
    }

    @GetMapping("metodoResponseEntityUsingParms/{id}")
    public ResponseEntity<Object> metodoResponseEntityUsingParms(@RequestParam Long id) {
        final Usuario newUser = new Usuario("Teste");

        String message;
        if (id < 5) {
            message = "Menor que 5" + newUser;
        } else {
            message = "Maior que 5";
        }

        // ResponseEntity<String> response = new ResponseEntity<String>("Hello World", HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
    }

    
}
