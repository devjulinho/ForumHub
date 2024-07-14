package com.forumhub.DTO;

import com.forumhub.model.Curso;
import com.forumhub.model.StatusTopico;
import com.forumhub.model.Topico;
import jakarta.persistence.Column;

import java.time.LocalDate;

public record ListagemTopicosDTO (
        Long id,
        String titulo,
        String messagem,
        @Column(name = "data_criacao")
        LocalDate dataCriacao,
        String autor,
        Curso curso,
        StatusTopico status) {

    public ListagemTopicosDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMessagem(), topico.getData_criacao(), topico.getAutor(), topico.getCurso(), topico.getStatus());
    }
}
