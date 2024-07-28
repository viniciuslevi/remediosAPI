package com.remedios.curso.Curso.Remedios.DTO;

import com.remedios.curso.Curso.Remedios.Laboratorio;
import com.remedios.curso.Curso.Remedios.Via;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarRemedio(@NotNull Long id, String nome, Via via, Laboratorio laboratorio, String lote, int quantidade, LocalDate validade) {

}
