package dev.jeffersonfreitas.api.service;

import br.com.jeffersonfreitas.dto.MessageDTO;
import br.com.jeffersonfreitas.utils.Constants;
import dev.jeffersonfreitas.api.connections.MessageProducer;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageProducer messageProducer;

    public MessageService(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void sendMessage(MessageDTO message) {
        this.messageProducer.sendMessage(Constants.MESSAGE_QUEUE, message);
    }
}
