package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
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
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missoes){
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
    @PutMapping("/alterar/{id}")
    public MissoesModel atualizarMissoes(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesService.atualizarMissao(id, missaoAtualizada);
    }

    // Deletar missoẽs
    @DeleteMapping("/deletar")
    public void deletarMissoes(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }


}
