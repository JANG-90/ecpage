package com.example.ecpage.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="item_name")
    private String itemName;
    private Integer price;
    @Column(name="item_detail")
    private String itemDetail;
}
