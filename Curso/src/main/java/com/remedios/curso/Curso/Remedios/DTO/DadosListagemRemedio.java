package com.remedios.curso.Curso.Remedios.DTO;

import com.remedios.curso.Curso.Remedios.Laboratorio;
import com.remedios.curso.Curso.Remedios.Remedio;
import com.remedios.curso.Curso.Remedios.Via;

import java.time.LocalDate;

public record DadosListagemRemedio(Long id, String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade, int quantidade) {

    public DadosListagemRemedio(Remedio remedio) {
        this(remedio.getId(), remedio.getNome(),remedio.getVia(),remedio.getLote(),remedio.getLaboratorio(),remedio.getValidade(), remedio.getQuantidade());
    }
}
