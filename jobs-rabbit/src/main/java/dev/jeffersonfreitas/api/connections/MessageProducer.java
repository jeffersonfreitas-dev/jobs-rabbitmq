package dev.jeffersonfreitas.api.connections;

import br.com.jeffersonfreitas.dto.MessageDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {


    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String queueName, MessageDTO messageDTO){
        this.rabbitTemplate.convertAndSend(queueName, messageDTO);
    }
}
