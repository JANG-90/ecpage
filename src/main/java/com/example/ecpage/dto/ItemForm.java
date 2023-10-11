package com.example.ecpage.dto;

import com.example.ecpage.entity.Item;

public class ItemForm {
    private Long id;
    private String itemName;
    private int price;
    private String itemDetail;

    public Item toEntity(){
        return new Item(id,itemName,price,itemDetail);
    }
}
