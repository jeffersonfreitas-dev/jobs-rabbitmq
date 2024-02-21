package dev.jeffersonfreitas.api.controller;

import br.com.jeffersonfreitas.dto.MessageDTO;
import dev.jeffersonfreitas.api.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDTO create(@RequestBody MessageDTO message) {
        service.sendMessage(message);
        return new MessageDTO();
    }
}
