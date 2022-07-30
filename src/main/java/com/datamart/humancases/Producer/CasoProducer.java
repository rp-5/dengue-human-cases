package com.datamart.humancases.Producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.stereotype.Component;

import com.datamart.humancases.DTO.ProducerDTO;
import com.datamart.humancases.entity.Human;

@Component
public class CasoProducer {
    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("routingkeycases")
    String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void casoProducerMensagem(Human human){
        rabbitTemplate.convertAndSend(exchange, routingKey, human);
    }
}
