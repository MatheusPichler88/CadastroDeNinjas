package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes) {
        MissoesDTO missao = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + missao.getNome() + " ID: " + missao.getId());
    }

    // Listar todas as missões
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> mostrarMissoes() {
        List<MissoesDTO> missao = missoesService.listarMissoes();
        return ResponseEntity.ok(missao);
    }

    // Listar as missões por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarMissoesID(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com esse ID: " + id + " não foi encontrada!");
        }
    }

    // Alterar dados das missões
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missao = missoesService.atualizarMissao(id, missaoAtualizada);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com esse ID: " + id + " não foi encontrada!");
        }
    }

    // Deletar missoẽs
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissoes(@PathVariable Long id) {
        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão com o ID: " + id + "deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com ID: " + id + " não foi encontrada!");
        }
    }
}
