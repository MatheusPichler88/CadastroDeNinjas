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
    public List<MissoesDTO> mostrarMissoes(){
        return missoesService.listarMissoes();
    }

    // Listar as missões por ID
    @GetMapping("/listar/{id}")
    public MissoesDTO mostrarMissoesID(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    // Alterar dados das missões
    @PutMapping("/alterar/{id}")
    public MissoesDTO atualizarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        return missoesService.atualizarMissao(id, missaoAtualizada);
    }

    // Deletar missoẽs
    @DeleteMapping("/deletar")
    public void deletarMissoes(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }


}
