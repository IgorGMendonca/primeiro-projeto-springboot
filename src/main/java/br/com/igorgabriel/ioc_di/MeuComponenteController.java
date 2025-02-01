package br.com.igorgabriel.ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("meuComponenteController")
public class MeuComponenteController {
            
  @Autowired
  MeuComponente meuComponente;

  @GetMapping("/")
    public String metodoDoMeuComponente() {
        
        var resultado = meuComponente.metodoDoMeuComponente();

        return resultado;
    }
}
