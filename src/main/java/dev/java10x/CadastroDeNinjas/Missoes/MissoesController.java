package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionando missão
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return missoesService.criarMissoes(missoes);
    }

    // Listar todas as missões
    @GetMapping("/listar")
    public List<MissoesModel> mostrarMissoes(){
        return missoesService.listarMissoes();
    }

    // Listar as missões por ID
    @GetMapping("/listar/{id}")
    public MissoesModel mostrarMissoesID(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    // Alterar dados das missões
    @PutMapping("/alterar")
    public String alterarMissoes(){
        return "Alterar Missões";
    }

    // Deletar missoẽs
    @DeleteMapping("/deletar")
    public void deletarMissoes(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }
}
