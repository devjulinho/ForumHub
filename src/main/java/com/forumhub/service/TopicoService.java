package com.forumhub.service;

import com.forumhub.DTO.DadosAtualizacaoTopico;
import com.forumhub.DTO.DadosTopicoDTO;
import com.forumhub.DTO.ListagemTopicosDTO;
import com.forumhub.model.StatusTopico;
import com.forumhub.model.Topico;
import com.forumhub.repository.TopicoRepository;
import com.forumhub.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;


    public void publicar(DadosTopicoDTO topicoCriado){
        repository.save(new Topico(topicoCriado));
    }


    public Page<ListagemTopicosDTO> listar(Pageable paginacao){
        return repository.findAllByStatusIsNotDeletado(paginacao).map(ListagemTopicosDTO::new);
    }

    @Transactional
    public ListagemTopicosDTO detalhar(Long id){
        try {
            Topico topico = repository.getReferenceById(id);
            return new ListagemTopicosDTO(topico);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("ID inválido!");
        }
    }

    public void atualizar(Long id, DadosAtualizacaoTopico dadosAtualizacao){
        Topico topico = repository.getReferenceById(id);
        topico.atualizarInformacoes(dadosAtualizacao);
    }

    public void deletar(Long id) {
        StatusTopico statusDeletado = StatusTopico.valueOf("DELETADO");
        Topico topico = repository.getReferenceById(id);
        topico.setStatus(statusDeletado);
    }
}
