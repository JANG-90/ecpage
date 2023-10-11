package com.example.ecpage.dto;

import com.example.ecpage.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter

public class ItemForm {
    private Long id;
    private String itemName;
    private Integer price;
    private String itemDetail;

    public Item toEntity(){

        return new Item(id,itemName,price,itemDetail);
    }
}
