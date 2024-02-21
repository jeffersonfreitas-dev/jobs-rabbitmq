package dev.jeffersonfreitas.api.events;

import br.com.jeffersonfreitas.dto.MessageDTO;
import br.com.jeffersonfreitas.utils.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = Constants.MESSAGE_QUEUE)
    private void messageConsumer(MessageDTO messageDTO){
        System.out.println(messageDTO.getText());
    }
}
