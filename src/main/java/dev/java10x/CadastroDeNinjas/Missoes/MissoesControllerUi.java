package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {

    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // LISTAR MISSÕES
    @GetMapping("/listar")
    public String listarMissoes(Model model) {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "listarMissoes";
    }

    // DETALHES DA MISSÃO
    @GetMapping("/detalhes/{id}")
    public String detalhesMissao(@PathVariable Long id, Model model){

        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        model.addAttribute("missao", missao);

        return "/detalhesMissao";
    }

    // FORMULÁRIO CRIAR MISSÃO
    @GetMapping("/novo")
    public String mostrarFormularioCriar(Model model) {
        model.addAttribute("missao", new MissoesDTO());
        return "criarMissao";
    }

    // SALVAR MISSÃO
    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missao) {
        missoesService.criarMissoes(missao);
        return "redirect:/missoes/ui/listar";
    }

    // FORMULÁRIO EDITAR
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {

        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao != null) {
            model.addAttribute("missao", missao);
            return "editarMissao";
        } else {
            return "redirect:/missoes/ui/listar";
        }
    }

    // ATUALIZAR MISSÃO
    @PostMapping("/atualizar/{id}")
    public String atualizarMissao(@PathVariable Long id, @ModelAttribute MissoesDTO missao) {

        missoesService.atualizarMissao(id, missao);
        return "redirect:/missoes/ui/listar";
    }

    // DELETAR
    @GetMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);
        return "redirect:/missoes/ui/listar";
    }

}