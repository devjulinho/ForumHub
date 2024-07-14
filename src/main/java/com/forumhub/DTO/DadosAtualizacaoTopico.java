package com.forumhub.DTO;

import com.forumhub.model.Curso;
import com.forumhub.model.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        String titulo,
        String messagem,
        Curso curso,
        StatusTopico status) {
}
