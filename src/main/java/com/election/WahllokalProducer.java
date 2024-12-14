package com.election;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;
import java.util.Properties;

public class WahllokalProducer {
    public static void main(String[] args) throws Exception {
        // Daten erstellen
        ElectionData data = new ElectionData();
        data.setRegionID("33123");
        data.setRegionName("Linz Bahnhof");
        data.setRegionAddress("Bahnhofsstrasse 27/9");
        data.setRegionPostalCode("Linz");
        data.setFederalState("Austria");
        data.setTimestamp("2024-09-12 11:48:21");

        CountingData countingData = new CountingData();
        countingData.setParties(List.of(
                new Party("OEVP", 322),
                new Party("SPOE", 301),
                new Party("FPOE", 231),
                new Party("GRUENE", 211),
                new Party("NEOS", 182)
        ));
        data.setCountingData(countingData);

        // JSON serialisieren
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(data);

        // Kafka-Producer erstellen
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>("wahllokal-queue", jsonData));

        System.out.println("Nachricht gesendet: " + jsonData);
        producer.close();
    }
}
