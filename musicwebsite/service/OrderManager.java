package com.example.musicwebsite.service;


import com.example.musicwebsite.model.domain.Order;

public interface OrderManager {
    void sendPassword(Order order, String reciveAddress);
    void sendCode(String code,String reciveAddress);
}