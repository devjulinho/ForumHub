package com.forumhub.repository;
import com.forumhub.model.Topico;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT t FROM Topico t WHERE t.status != DELETADO")
    Page<Topico> findAllByStatusIsNotDeletado(Pageable paginacao);
}
