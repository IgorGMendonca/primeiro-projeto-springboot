package br.com.igorgabriel.ioc_di;

import org.springframework.stereotype.Service;

@Service
public class MeuComponente {
    
    public String metodoDoMeuComponente() {
        return "Método do meu componente";
    }
}
