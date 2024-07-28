package com.remedios.curso.Curso.Remedios;

import com.remedios.curso.Curso.Remedios.DTO.DadosAtualizarRemedio;
import com.remedios.curso.Curso.Remedios.DTO.DadosCadastroRemedio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "Remedio")
@Entity(name = "remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Remedio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private int quantidade;
    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    private boolean ativo;

    public Remedio(DadosCadastroRemedio dados) {
        this.ativo = true; //como ele recebeu o DTO pra salvar no BD, tem q ta ativo
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }

    public void atualizarInformacoes(DadosAtualizarRemedio dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.via() != null){
            this.via = dados.via();
        }
        if(dados.laboratorio() != null){
            this.laboratorio = dados.laboratorio();
        }
        if(dados.lote() != null){
            this.nome = dados.lote();
        }
        if (dados.quantidade() != 0){
            this.quantidade = dados.quantidade();
        }
        if (dados.validade() != null){
            this.validade = dados.validade();
        }

    }

    public void inativar(Long id) {
        this.ativo = false;
    }

    public void reativar(Long id) {
        this.ativo = true;
    }
}
