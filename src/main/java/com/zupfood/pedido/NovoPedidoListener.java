package com.zupfood.pedido;

import com.zupfood.pedido.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NovoPedidoListener {
    Logger logger = LoggerFactory.getLogger(NovoPedidoListener.class);

    @Autowired
    PedidoRepository pedidoRepository;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.novo-pedido}")
    public void recebe(NovoPedidoEvent event) {
        Optional<Pedido> pedido = pedidoRepository.findById(event.getId());
        logger.info("Evento NOVO_PEDIDO Processando ...");
        if (pedido.isPresent()) {
            pedido.get().novoPedidoProcessado();
            pedidoRepository.save(pedido.get());
        }
        logger.info("Evento NOVO_PEDIDO lido com sucesso: {}", event.toString());
    }
}

