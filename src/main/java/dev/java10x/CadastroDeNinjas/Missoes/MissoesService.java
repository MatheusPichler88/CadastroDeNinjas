package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;


    // Listar todas as missões
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // Listar todas as missões por ID
    public MissoesModel listarMissoesPorId (Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }

    // Criar as missões
    public MissoesModel criarMissoes(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    // Deletar missões por ID
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
