package com.example.musicwebsite.service.impl;
 

import com.example.musicwebsite.model.domain.Order;
import com.example.musicwebsite.service.OrderManager;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleOrderManager implements OrderManager {

    public void setMailSender(JavaMailSender mailSender) {
    }

    public void sendPassword(Order order, String reciveAddress) {

    }

    public void sendCode(String code, String reciveAddress) {

    }
}