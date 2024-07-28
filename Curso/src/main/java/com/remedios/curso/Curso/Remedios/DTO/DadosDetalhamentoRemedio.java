package com.remedios.curso.Curso.Remedios.DTO;

import com.remedios.curso.Curso.Remedios.Laboratorio;
import com.remedios.curso.Curso.Remedios.Remedio;
import com.remedios.curso.Curso.Remedios.Via;

import java.time.LocalDate;

public record DadosDetalhamentoRemedio(Long id, String nome, Via via, String lote, int quantidade, LocalDate validade, Laboratorio laboratorio) {
    public DadosDetalhamentoRemedio(Remedio remedio){
        this (
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio()
        );
    }
}
