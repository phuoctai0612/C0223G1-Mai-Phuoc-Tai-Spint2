package com.example.movie.repository;

import com.example.movie.model.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoryRepository extends JpaRepository<History,Long> {
    History findByAccount_IdAndFlagTrue(Long id);
    Page<History> findByAccount_Id(Pageable pageable,Long id);
}
