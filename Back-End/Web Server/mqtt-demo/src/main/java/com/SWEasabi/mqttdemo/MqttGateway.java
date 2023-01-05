package com.SWEasabi.mqttdemo;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {
	
	void sendToMqtt(String status, @Header(MqttHeaders.TOPIC) String topic);
}
