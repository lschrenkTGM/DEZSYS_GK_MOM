package com.election;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Properties;

public class ZentralConsumer {
    public static void main(String[] args) {
        // Kafka-Consumer-Einstellungen
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "wahllokal-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("wahllokal-queue"));

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("Warte auf Nachrichten...");
        while (true) {
            // Nachrichten abrufen
            ConsumerRecords<String, String> records = consumer.poll(1000);
            records.forEach(record -> {
                try {
                    // JSON-Daten in Java-Objekt deserialisieren
                    ElectionData data = objectMapper.readValue(record.value(), ElectionData.class);

                    // Daten ausgeben
                    System.out.println("Nachricht empfangen:");
                    System.out.println("Region ID: " + data.getRegionID());
                    System.out.println("Region Name: " + data.getRegionName());
                    System.out.println("Bundesland: " + data.getFederalState());
                    data.getCountingData().getParties().forEach(party ->
                            System.out.println("Partei: " + party.getPartyID() + ", Stimmen: " + party.getAmountVotes())
                    );
                } catch (Exception e) {
                    System.err.println("Fehler beim Verarbeiten der Nachricht: " + record.value());
                    e.printStackTrace();
                }
            });
        }
    }
}
