//package com.jowdev.simpleapi.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//    @Value("${app.rabbitmq.queue}")
//    private String queueName;
//
//    @Value("${app.rabbitmq.exchange}")
//    private String exchange;
//
//    @Value("${app.rabbitmq.routingkey}")
//    private String routingKey;
//
//    @Bean
//    public Queue queue() {
//        return new Queue(queueName, false);
//    }
//
//    @Bean
//    public DirectExchange exchange() {
//        return new DirectExchange(exchange);
//    }
//
//    @Bean
//    public Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
//    }
//
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(jsonMessageConverter());
//        return rabbitTemplate;
//    }
//}