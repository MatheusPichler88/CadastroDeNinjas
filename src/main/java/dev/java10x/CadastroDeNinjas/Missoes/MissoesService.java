package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    // Listar todas as missões
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // Listar todas as missões por ID
    public MissoesDTO listarMissoesPorId (Long id){
        Optional<MissoesModel> missoesPorID = missoesRepository.findById(id);
        return missoesPorID.map(missoesMapper::map).orElse(null);
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
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missaoDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
