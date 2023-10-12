package com.example.ecpage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
    @GetMapping("/save")
    public String save() {
        log.info("테스트");
        return "/member/save";
    }
}
