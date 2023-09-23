package com.example.movie.service.impl;

import com.example.movie.model.History;
import com.example.movie.repository.IHistoryRepository;
import com.example.movie.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService implements IHistoryService {
    @Autowired
    private IHistoryRepository historyRepository;

    @Override
    public void createHistory(History history) {
        historyRepository.save(history);
    }

    @Override
    public History findByAccount_IdAndFlagTrue(Long id) {
        return historyRepository.findByAccount_IdAndFlagTrue(id);
    }

    @Override
    public Page<History> findByAccount_Id(Pageable pageable,Long id) {
        return historyRepository.findByAccount_Id(pageable,id);
    }

    @Override
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public void saveHistory(History history) {
        historyRepository.save(history);
    }
}
