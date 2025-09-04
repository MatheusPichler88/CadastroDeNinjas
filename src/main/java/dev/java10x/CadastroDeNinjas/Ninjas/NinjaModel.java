package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Entity ele transforma uma classe em uma entidade do BD
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro ")
@NoArgsConstructor // Cria o construtor vazio
@AllArgsConstructor // Cria o construtor com todos os argumentos.
@Data // Cria os getter and setters

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // @ManyToOne Um ninja tem uma unica missão
    @ManyToMany
    @JoinColumn(name = "missoes_id") //Foreing key
    private MissoesModel missoes;


}