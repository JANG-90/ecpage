package com.example.ecpage.dto;


import com.example.ecpage.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class BoardForm {


    private Long id;
    private String title;
    private String content;

    public Board toEntity() {
        return new Board(id, title, content);

    }
}
