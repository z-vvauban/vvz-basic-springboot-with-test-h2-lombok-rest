package com.vv.configuration;

import com.vv.avro.VVMessage;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class KafkaProducerConfig {
    @Value( value = "${spring.kafka.bootstrap-servers}" )
    private String bootstrapAddress;

    @Bean
    public ProducerFactory<String, VVMessage> producerFactory( KafkaProperties kafkaProperties ) {
        Map<String, Object> configProps = kafkaProperties.buildProducerProperties();
        configProps.put("schema.registry.url", "http://localhost:8081");
//        configProps.put(
//                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                bootstrapAddress );
//        configProps.put(
//                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class );
//        configProps.put(
//                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class );

//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                  io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        return new DefaultKafkaProducerFactory<>( configProps );
    }

    @Bean
    public KafkaTemplate<String, VVMessage> kafkaTemplate( KafkaProperties kafkaProperties ) {
        return new KafkaTemplate<>( producerFactory( kafkaProperties ) );
    }
}
