package dev.jeffersonfreitas.api.connections;

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
        Queue stockQueue = this.queue("ESTOQUE_QUEUE");
        Queue priceQueue = this.queue("PRECO_QUEUE");

        DirectExchange exchange = this.directExchange();
        Binding bindStock = this.relationshipBinding(stockQueue, exchange);
        Binding bindPrice = this.relationshipBinding(priceQueue, exchange);

        this.amqpAdmin.declareQueue(stockQueue);
        this.amqpAdmin.declareQueue(priceQueue);
        this.amqpAdmin.declareExchange(exchange);
        this.amqpAdmin.declareBinding(bindStock);
        this.amqpAdmin.declareBinding(bindPrice);
    }
}
