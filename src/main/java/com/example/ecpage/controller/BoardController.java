package com.example.ecpage.controller;


import com.example.ecpage.dto.BoardForm;
import com.example.ecpage.entity.Board;
import com.example.ecpage.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
@Slf4j


public class BoardController {
    @Autowired
    private BoardRepository boardRepository;


    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam(required = false, defaultValue = "") String searchText) {
//        Page<Board> boards = boardRepository.findAll(pageable);
        Page<Board> boards = boardRepository.findByTitleContainingOrContentContaining(searchText,searchText,pageable);
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        List<BoardForm> boardFormList = new ArrayList<>();
        for (Board board : boards) {
            BoardForm boardForm = new BoardForm(board.getId(), board.getTitle(), board.getContent());
            boardFormList.add(boardForm);
        }
            log.info("dto리스트조회메시지");
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        BoardForm boardForm = new BoardForm();
        if (id != null) {
            Board board = boardRepository.findById(id).orElse(null);
            if (board != null) {
                boardForm.setId(board.getId());
                boardForm.setTitle(board.getTitle());
                boardForm.setContent(board.getContent());
                log.info("dto글수정메시지");
            }
        }
        model.addAttribute("boardForm", boardForm);
        return "/board/form";
    }

    @PostMapping("/form")
    public String form2(@Valid BoardForm boardForm, BindingResult bindingkesut) {
        if (bindingkesut.hasErrors()) {
            return "/board/form";
        }
        Board board = new Board();
        board.setId(boardForm.getId());
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());
        log.info("dto저장메시지");
        boardRepository.save(board);
        return "redirect:/board/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        Board target = boardRepository.findById(id).orElse(null);
        if (target != null) {
            log.info("삭제메시지");
            boardRepository.delete(target);
        }
        return "redirect:/board/list";
    }


}
