package com.travelers.event.consumer;

import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


@Service
public class PurchaseOrderConsumer {

   public static String AMQP_HOST = "ec2-15-164-226-16.ap-northeast-2.compute.amazonaws.com";
   public static String AMQP_USERNAME = "rabbitmq";
   public static String AMQP_PASSWORD = "password123";
   

   public void consume(String exchangeName) throws Exception {
      ConnectionFactory factory = new ConnectionFactory();
      factory.setHost(AMQP_HOST);
      factory.setUsername(AMQP_USERNAME);
      factory.setPassword(AMQP_PASSWORD);
      

      Connection connection = factory.newConnection();
      Channel channel = connection.createChannel();

      channel.exchangeDeclare(exchangeName, "fanout");
      String queueName = channel.queueDeclare().getQueue();
      channel.queueBind(queueName, exchangeName, "");

      DeliverCallback deliverCallback = (consumerTag, delivery) -> {
         System.out.println(delivery);
         String message = new String(delivery.getBody(), "UTF-8");
         System.out.println(" [x] Received '" + message + "'");

      };
      channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
      });
   }

}