package com.vv.configuration;

import com.vv.avro.VVMessage;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value( value = "${spring.kafka.bootstrap-servers}" )
    private String bootstrapAddress;

    @Bean
    public ConsumerFactory<String, VVMessage> consumerFactory( KafkaProperties kafkaProperties ) {
        Map<String, Object> props = kafkaProperties.buildConsumerProperties();
        props.put( "schema.registry.url", "http://localhost:8081" );
        props.put( KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true );
        //        props.put(
        //                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
        //                bootstrapAddress);
        //        props.put(
        //                ConsumerConfig.GROUP_ID_CONFIG,
        //                "foo");
        //        props.put(
        //                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
        //                StringDeserializer.class );
        //        props.put(
        //                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
        //                StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>( props );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, VVMessage>
    kafkaListenerContainerFactory( KafkaProperties kafkaProperties ) {

        ConcurrentKafkaListenerContainerFactory<String, VVMessage> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory( consumerFactory( kafkaProperties ) );
        return factory;
    }
}
