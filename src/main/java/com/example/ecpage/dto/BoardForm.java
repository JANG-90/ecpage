package com.example.ecpage.dto;


import com.example.ecpage.entity.Board;
import lombok.*;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BoardForm {


    private Long id;
    private String title;
    private String content;

    public Board toEntity() {

        return new Board(id, title, content);
    }

}
