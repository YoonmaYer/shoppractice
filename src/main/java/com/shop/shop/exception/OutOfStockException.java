package com.shop.shop.exception;

public class OutOfStockException extends RuntimeException{

    //상품의 주문 수량보다 재고의 수가 적을때 발생시킬 예외처리
    public OutOfStockException(String message) {
        super(message);
    }
}
