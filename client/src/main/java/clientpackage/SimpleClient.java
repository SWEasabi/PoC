package clientpackage;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SimpleClient implements MqttCallback {

MqttClient client;

public SimpleClient() {
}

public static void main(String[] args) {
    new SimpleClient().doDemo();
}

public void doDemo() {
    try {
        client = new MqttClient("tcp://localhost:1883", "Client");
        client.connect();
        client.setCallback(this);
        client.subscribe("lamps/1/stato");
        client.subscribe("lamps/2/stato");
    } catch (MqttException e) {
        e.printStackTrace();
    }
}

public void connectionLost(Throwable cause) {
    System.out.println("Connection lost");

}

public void messageArrived(String topic, MqttMessage message)
        throws Exception {
	System.out.println("Message received in topic: " + topic);
	System.out.println("I'm turning the lamp's status to: " + message);  
}

public void deliveryComplete(IMqttDeliveryToken token) {
    System.out.println("Delivery complete");

}

}