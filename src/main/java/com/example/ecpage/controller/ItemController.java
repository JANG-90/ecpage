package com.example.ecpage.controller;

import com.example.ecpage.entity.Item;
import com.example.ecpage.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/shopitem")
@Slf4j

public class ItemController {

    @Autowired
    private ItemRepository itemRepository;


    @GetMapping("/itemlist1")
    public String list(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "shopitem/itemlist1";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if (id == null) {
            model.addAttribute("item", new Item());
        } else {
            Item item = itemRepository.findById(id).orElse(null);
            model.addAttribute("item", item);
        }
        return "/shopitem/form";
    }

    @PostMapping("/form")
    public String form2(@Valid Item item, BindingResult
            bindingkesut) {
        if (bindingkesut.hasErrors()) {
            return "/shopitem/form";
        }
        itemRepository.save(item);
        return "redirect:/shopitem/itemlist1";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        Item target =itemRepository.findById(id).orElse(null);
        if (target != null){
            itemRepository.delete(target);
        }
        return "redirect:/shopitem/itemlist1";
    }
}
