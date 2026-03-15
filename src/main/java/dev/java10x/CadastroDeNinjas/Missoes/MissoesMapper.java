package dev.java10x.CadastroDeNinjas.Missoes;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){

        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());

        return missoesModel;

    }

    public MissoesDTO map(MissoesModel missoesModel){

        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());

        // Se a missão tiver ninjas, podemos pegar o ID do primeiro para mostrar no formulário/lista
        if (missoesModel.getListaNinjas() != null && !missoesModel.getListaNinjas().isEmpty()) {
            missoesDTO.setNinjaId(missoesModel.getListaNinjas().get(0).getId());
        }

        return missoesDTO;
    }

}
