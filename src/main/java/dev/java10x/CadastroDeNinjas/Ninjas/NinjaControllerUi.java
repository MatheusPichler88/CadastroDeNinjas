package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesService;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesDTO;
import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final MissoesService missoesService;
    private final NinjaService ninjaService;

    public NinjaControllerUi(MissoesService missoesService, NinjaService ninjaService) {
        this.missoesService = missoesService;
        this.ninjaService = ninjaService;
    }

    // LISTAR TODOS
    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    // DETALHES DO NINJA
    @GetMapping("/detalhes/{id}")
    public String mostrarDetalhes(@PathVariable Long id, Model model) {

        NinjaDTO ninja = ninjaService.listarNinjasPorID(id);

        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesninja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado!");
            return "listarNinjas";
        }
    }

    // FORMULÁRIO DE CRIAÇÃO
    @GetMapping("/novo")
    public String mostrarFormularioCriar(Model model) {

        model.addAttribute("ninja", new NinjaDTO());

        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);

        return "criarNinja";
    }

    // SALVAR NOVO NINJA
    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja) {
        ninjaService.criarNinja(ninja);
        return "redirect:/ninjas/ui/listar";
    }

    // FORMULÁRIO DE EDIÇÃO
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {

        NinjaDTO ninja = ninjaService.listarNinjasPorID(id);

        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "editarNinja";
        } else {
            return "redirect:/ninjas/ui/listar";
        }
    }

    // ATUALIZAR NINJA
    @PostMapping("/atualizar/{id}")
    public String atualizarNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninja) {

        ninjaService.atualizarNinja(id, ninja);
        return "redirect:/ninjas/ui/listar";
    }

    // DELETAR
    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorID(id);
        return "redirect:/ninjas/ui/listar";
    }

}