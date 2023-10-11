package com.example.ecpage.service;

import com.example.ecpage.entity.Board;
import com.example.ecpage.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Transactional
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public List<Board> index(){
        return boardRepository.findAll();
    }




}
