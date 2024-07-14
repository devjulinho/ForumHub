package com.forumhub.DTO;

import com.forumhub.model.Curso;
import com.forumhub.model.StatusTopico;
import com.forumhub.model.Topico;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosTopicoDTO (
        @NotBlank String titulo,
        @NotBlank String messagem,
        @NotBlank
        @Column(name = "data_criacao")
        LocalDate dataCriacao,
        @NotBlank String autor,
        @NotBlank Curso curso,
        @NotBlank StatusTopico status) {

        public DadosTopicoDTO(Topico topico){
                this(topico.getTitulo(), topico.getMessagem(), topico.getData_criacao(), topico.getAutor(), topico.getCurso(), topico.getStatus());
        }
}
