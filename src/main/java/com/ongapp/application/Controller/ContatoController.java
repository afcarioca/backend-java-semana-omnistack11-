package com.ongapp.application.Controller;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContatoController {
        
    // Query
    // @GetMapping("/contatos")
    // public List<Contato> getContato(@RequestParam MultiValueMap<String, String> query) {
        
    //     System.out.println(query);
                
    //     List<Contato> contatos = new ArrayList<>();

    //     contatos.add(new Contato("Semana OmniStack 11.0", "André Freitas"));
    //     contatos.add( new Contato("Semana OmniStack 11.0", "Eduardo"));

    //     return contatos;
       
    // }
    
    
    //Routes
    // @GetMapping("/contatos/{id}")
    // public List<Contato> getContato(@PathVariable String id) {
        
    //     System.out.println(id);
                
    //     List<Contato> contatos = new ArrayList<>();

    //     contatos.add(new Contato("Semana OmniStack 11.0", "André Freitas"));
    //     contatos.add( new Contato("Semana OmniStack 11.0", "Eduardo"));

    //     return contatos;
       
    // }

    @PostMapping("/contatos")
    public String post(@RequestBody String body) {
        System.out.println(body);

        return body;
    }
}