package com.zupfood.pedido;

import com.zupfood.pedido.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PedidoCanceladoListener {

    Logger logger = LoggerFactory.getLogger(PedidoCanceladoListener.class);

    @Autowired
    PedidoRepository pedidoRepository;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.pedido-cancelado}")
    public void recebe(PedidoCanceladoEvent event){
        Optional<Pedido> pedido = pedidoRepository.findById(event.getId());
        logger.info("Evento PEDIDO CANCELADO Processando ...");

        if(pedido.isPresent()){
            pedido.get().cancelar();
            pedidoRepository.save(pedido.get());
        }

        logger.info("Evento PEDIDO CANCELADO lido com sucesso: {}", event.toString());
    }

}