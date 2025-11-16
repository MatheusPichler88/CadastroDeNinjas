package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class MissoesController {

    // Adicionando missão
    @PostMapping("/criarMissoes")
    public String criarMissao(){
        return "Missão criada";
    }

    // Mostrar todas as missões
    @GetMapping("/mostrarMissoes")
    public String mostrarMissoes(){
        return "Mostrando Missões";
    }

    // Mostrar as missões por ID
    @GetMapping("/mostrarMissoesID")
    public String mostrarMissoesID(){
        return "Mostrando Missões por ID";
    }

    // Alterar dados das missões
    @PutMapping("/alterarID")
    public String alterarMissoesID(){
        return "Alterar Missões por ID";
    }

    // Deletar missoẽs
    @DeleteMapping("/deletarMissoesID")
    public String deletarMissoesID(){
        return "Deletar Missões por ID";
    }
}
