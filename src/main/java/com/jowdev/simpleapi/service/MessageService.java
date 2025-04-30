package com.jowdev.simpleapi.service;

import com.jowdev.simpleapi.model.Message;
import com.jowdev.simpleapi.model.User;
import com.jowdev.simpleapi.repository.MessageRepository;
import com.jowdev.simpleapi.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private RabbitMQService rabbitMQService;

    public Message createMessage(String content) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User sender = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();

        Message message = new Message();
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());
        message.setSender(sender);

        Message savedMessage = messageRepository.save(message);

//        rabbitMQService.sendMessage(savedMessage);

        return savedMessage;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

//    @RabbitListener(queues = "${app.rabbitmq.queue}")
//    public void receiveMessage(Message message) {
//        System.out.println("Mensagem recebida: " + message.getContent());
//        System.out.println("Enviada por: " + message.getSender().getUsername());
//        System.out.println("Timestamp: " + message.getTimestamp());
//    }
}