package com.forumhub.controller;

import com.forumhub.DTO.DadosAtualizacaoTopico;
import com.forumhub.DTO.DadosTopicoDTO;
import com.forumhub.DTO.ListagemTopicosDTO;
import com.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosTopicoDTO topicoCriado){
        service.publicar(topicoCriado);
    }

    @GetMapping
    public Page<ListagemTopicosDTO> listar(@PageableDefault(size = 10) Pageable paginacao){
        return service.listar(paginacao);
    }

    @GetMapping("/{id}")
    public ListagemTopicosDTO detalhar(@PathVariable Long id){
        return service.detalhar(id);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoTopico dadosAtualizacao){
        service.atualizar(dadosAtualizacao.id(), dadosAtualizacao);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        service.deletar(id);
    }






}
