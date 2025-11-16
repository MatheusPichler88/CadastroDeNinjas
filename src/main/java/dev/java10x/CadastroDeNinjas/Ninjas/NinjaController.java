package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/adicionar")
    public String criarNinja(){
        return "Ninja criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/mostrar")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninjas";
    }
    // Mostrar todos os ninjas por id (READ)
    @GetMapping("/mostrarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar Ninjas por ID";
    }
    // Alterar dados dos ninjas (UPTDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninjas por ID";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
        public String deletarNinjaPorId(){
            return "Alterar Ninjas por ID";
        }
    }

