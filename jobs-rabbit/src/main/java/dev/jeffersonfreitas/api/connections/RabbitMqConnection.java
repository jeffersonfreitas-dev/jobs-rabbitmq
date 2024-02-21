package dev.jeffersonfreitas.api.connections;

import br.com.jeffersonfreitas.utils.Constants;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConnection {

    private final AmqpAdmin amqpAdmin;

    public RabbitMqConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String name) {
        return new Queue(name, true, false, false);
    }

    private DirectExchange directExchange(){
        return new DirectExchange("amq.direct");
    }

    private Binding relationshipBinding(Queue queue, DirectExchange directExchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE,
                directExchange.getName(), directExchange.getName(), null);
    }

    @PostConstruct
    private void createQueue(){
        Queue messageQueue = this.queue(Constants.MESSAGE_QUEUE);

        DirectExchange exchange = this.directExchange();
        Binding messageBind = this.relationshipBinding(messageQueue, exchange);

        this.amqpAdmin.declareQueue(messageQueue);
        this.amqpAdmin.declareExchange(exchange);
        this.amqpAdmin.declareBinding(messageBind);
    }
}
