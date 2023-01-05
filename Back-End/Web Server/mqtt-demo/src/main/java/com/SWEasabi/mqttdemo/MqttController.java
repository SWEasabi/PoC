package com.SWEasabi.mqttdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController {
	
	@Autowired
	MqttGateway mqttGateway;
	
	private final LampRepository repository;

	  MqttController(LampRepository repository) {
	    this.repository = repository;
	  }
	  
	  @GetMapping("/lamps")
	  List<Lamp> all() {
				System.out.println("List of lamps has been requested");
				
				mqttGateway.sendToMqtt("La lista delle lampade e' stata richiesta", "out");
				return repository.findAll();
	  }
	  
	  @GetMapping("/lamps/{id}")
	  Lamp one(@PathVariable Long id) {
	    
		System.out.println("Lamp " + id + "has been requested");
		
		mqttGateway.sendToMqtt("La lampada " + id + "e' stata richiesta", "out");
	    return repository.findById(id)
	      .orElseThrow(() -> new LampNotFoundException(id));
	  }
	  
	  @PostMapping("/addLamps")
	  Lamp newLamp(@RequestBody Lamp newEmployee) {
		  
		mqttGateway.sendToMqtt("Inserisco nuova lampada", "out");
	    return repository.save(newEmployee);
	  }
}
