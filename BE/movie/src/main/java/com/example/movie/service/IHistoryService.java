package com.example.movie.service;

import com.example.movie.model.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHistoryService  {

    void createHistory(History history);
    History findByAccount_IdAndFlagTrue(Long id);
    Page<History> findByAccount_Id(Pageable pageable,Long id);
    List<History> findAll();
    void saveHistory(History history);
}
