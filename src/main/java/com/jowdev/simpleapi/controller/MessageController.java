package com.jowdev.simpleapi.controller;

import com.jowdev.simpleapi.dto.MessageRequest;
import com.jowdev.simpleapi.model.Message;
import com.jowdev.simpleapi.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
//config do swagger
@Tag(name = "Mensagens", description = "API para gerenciamento de mensagens")
@SecurityRequirement(name = "Bearer Authentication")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    @Operation(summary = "Criar uma nova mensagem")
    public ResponseEntity<Message> createMessage(@RequestBody MessageRequest messageRequest) {
        Message message = messageService.createMessage(messageRequest.getContent());
        return ResponseEntity.ok(message);
    }

    @GetMapping
    @Operation(summary = "Listar todas as mensagens")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }
}