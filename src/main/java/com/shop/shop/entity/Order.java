package com.shop.shop.entity;

import com.shop.shop.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    private LocalDateTime orderDate;    //주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;    //주문상태

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true) //부모 엔티티의 영속성 상태변화를 자식 엔티티에 모두 전이
    private List<OrderItem> orderItems = new ArrayList<>(); // 하나의 주문이 여러개의 주문 상품을 가질 수 있으므로 ArrayList

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
