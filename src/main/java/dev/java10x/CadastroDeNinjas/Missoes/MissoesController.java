package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // Adicionando missão
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada";
    }

    // Mostrar todas as missões
    @GetMapping("/mostrar")
    public String mostrarMissoes(){
        return "Mostrando Missões";
    }

    // Mostrar as missões por ID
    @GetMapping("/mostrarID")
    public String mostrarMissoesID(){
        return "Mostrando Missões por ID";
    }

    // Alterar dados das missões
    @PutMapping("/alterar")
    public String alterarMissoes(){
        return "Alterar Missões";
    }

    // Deletar missoẽs
    @DeleteMapping("/deletar")
    public String deletarMissoes(){
        return "Deletar Missões";
    }
}
