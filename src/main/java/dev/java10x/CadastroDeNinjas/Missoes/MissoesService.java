package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    @Autowired
    private NinjaRepository ninjaRepository;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

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
        MissoesModel missao = missoesMapper.map(missoesDTO);
        missao = missoesRepository.save(missao);
        if (missoesDTO.getNinjaId() != null) {
            final MissoesModel missaoSalva = missao;
            ninjaRepository.findById(missoesDTO.getNinjaId()).ifPresent(ninja -> {
                ninja.setMissoes(missaoSalva);
                ninjaRepository.save(ninja);
            });
        }
        return missoesMapper.map(missao);
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
