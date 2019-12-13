package com.travelers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.travelers.event.consumer.PurchaseOrderConsumer;


@SpringBootApplication
public class TravelersApplication {

   @Autowired
   private PurchaseOrderConsumer consumer;
   
   public static void main(String[] args) throws Exception {
      SpringApplication.run(TravelersApplication.class, args);
   }
   
   @PostConstruct
   public void init() throws Exception {
      consumer.consume("create-order");       
   }   
}