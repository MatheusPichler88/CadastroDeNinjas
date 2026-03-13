package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

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
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    // Deletar missões por ID
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    // Atualizar missões
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada){
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            missoesRepository.save(missaoAtualizada);
        }
        return null;
    }
}
