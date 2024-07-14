package com.forumhub.model;

import com.forumhub.DTO.DadosAtualizacaoTopico;
import com.forumhub.DTO.DadosTopicoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String messagem;
    private LocalDate data_criacao;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    public Topico(DadosTopicoDTO topicoCriado) {
        this.titulo = topicoCriado.titulo();
        this.messagem = topicoCriado.messagem();
        this.autor = topicoCriado.autor();
        this.data_criacao = topicoCriado.dataCriacao();
        this.curso = topicoCriado.curso();
        this.status = topicoCriado.status();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dadosAtualizacao) {
        if(dadosAtualizacao.titulo() != null){
            this.titulo = dadosAtualizacao.titulo();
        }
        if(dadosAtualizacao.messagem() != null){
            this.messagem = dadosAtualizacao.messagem();
        }
        if(dadosAtualizacao.titulo() != null){
            this.curso = dadosAtualizacao.curso();
        }
        if(dadosAtualizacao.titulo() != null){
            this.status = dadosAtualizacao.status();
        }
    }
}
