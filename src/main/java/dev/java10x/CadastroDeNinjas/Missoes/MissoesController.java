package dev.java10x.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria uma nova missão", description = "Rota cria uma nova missão e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão")
    })
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes) {
        MissoesDTO missao = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + missao.getNome() + " ID: " + missao.getId());
    }

    // Listar todas as missões
    @GetMapping("/listar")
    @Operation(summary = "Lista todas as missões", description = "Retorna uma lista de todas as missões cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<MissoesDTO>> mostrarMissoes() {
        List<MissoesDTO> missao = missoesService.listarMissoes();
        return ResponseEntity.ok(missao);
    }

    // Listar as missões por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Busca missão por ID", description = "Busca uma missão específica através do seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
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
    @Operation(summary = "Atualiza missão", description = "Altera os dados de uma missão existente pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
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
    @Operation(summary = "Deleta uma missão", description = "Remove uma missão do banco de dados pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<String> deletarMissoes(@PathVariable Long id) {
        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão com o ID: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com ID: " + id + " não foi encontrada!");
        }
    }
}