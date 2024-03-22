package com.vv.service;

import com.vv.avro.VVMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, VVMessage> kafkaTemplate;

    public void sendMessage( String msg ) {
        VVMessage vvMessage = new VVMessage();
        vvMessage.setBar( 1L );
        vvMessage.setFoo( "Foo "+msg );
        vvMessage.setWiz( Instant.now() );
        kafkaTemplate.send( "vvz59", vvMessage );
    }
}
