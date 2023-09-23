package com.example.movie.controller;

import com.example.movie.model.History;
import com.example.movie.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private IHistoryService historyService;
    @GetMapping("/{id}")
    public ResponseEntity<History> getHistory(@PathVariable("id")Long id){
        History history=historyService.findByAccount_IdAndFlagTrue(id);
        if (history==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(history,HttpStatus.OK);
        }
    }
     @GetMapping("/list/{id}")
     @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> getListHistory(@PageableDefault(size = 5) Pageable pageable, @PathVariable("id")Long id){
        Page<History> history=historyService.findByAccount_Id(pageable,id);
        if (history==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(history,HttpStatus.OK);
        }
    }

}
