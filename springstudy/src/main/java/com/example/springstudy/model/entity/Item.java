package com.example.springstudy.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String content;


    // onetomany
    // LAZY = 지연로딩, EAGER = 즉시로딩

    // LAZY = SELECT * FROM item where id = ?

    // EAGER =
    // item_id = order_detail.item_id
    // user_id = order_datail.user_id
    // where item.id = ?
    // 연관관계 설정된 모든 테이블 join이 일어나며, 성능의 저하나 가지고 오지 못할 위험이 있음. 연관관계 설정시 LAZY를 추천함.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

}
