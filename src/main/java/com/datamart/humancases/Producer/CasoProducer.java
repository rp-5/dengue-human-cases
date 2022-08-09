package com.datamart.humancases.Producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.datamart.humancases.entity.Human;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CasoProducer {
    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("routingkeycases")
    String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void casoProducerMensagem(Human human) {
        try {
            String json = new ObjectMapper().writeValueAsString(human);
            rabbitTemplate.convertAndSend(exchange, routingKey, json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
}
