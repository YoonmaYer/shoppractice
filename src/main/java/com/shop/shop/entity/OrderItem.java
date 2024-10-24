package com.shop.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    // 하나의 상품은 여러 주문 상품으로 들어갈 수 있음. 주문 상품 기준으로 N:1 단방향 매핑
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    // 한 번의 주문에 여러 개의 상품을 주문할 수 있음. N:1 매핑
    @ManyToOne(fetch = FetchType.LAZY)  //지연 로딩 방식
    @JoinColumn(name="order_id")
    private Order order;

    private int orderPrice; //주문가격

    private int count;  //수량

    //private LocalDateTime regTime;

    //private LocalDateTime updateTime;
}
