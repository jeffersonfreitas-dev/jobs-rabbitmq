package dev.jeffersonfreitas.api.service;

import dev.jeffersonfreitas.api.connections.MessageProducer;
import dev.jeffersonfreitas.api.dto.MessageDTO;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageProducer messageProducer;

    public MessageService(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void sendMessage(MessageDTO message) {
        this.messageProducer.sendMessage("ESTOQUE_QUEUE", message);
    }
}
