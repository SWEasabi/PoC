package com.SWEasabi.mqttdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
public class MqttController {
	
	@Autowired
	MqttGateway mqttGateway;
	
	private final LampRepository repository;

	  MqttController(LampRepository repository) {
	    this.repository = repository;
	  }
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @GetMapping("/lamps")
	  List<Lamp> all() {
				System.out.println("List of lamps has been requested");
				
				mqttGateway.sendToMqtt("La lista delle lampade e' stata richiesta", "lamps");
				return repository.findAll();
	  }
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @GetMapping("/lamps/{id}")
	  Lamp one(@PathVariable Long id) {
	    
		System.out.println("Lamp " + id + "has been requested");
		
		mqttGateway.sendToMqtt("La lampada " + id + " e' stata richiesta", "lamps/" + id);
	    return repository.findById(id)
	      .orElseThrow(() -> new LampNotFoundException(id));
	  }
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @PutMapping("/lamps/{id}")
	  ResponseEntity<?> update(@PathVariable Long id, @RequestBody String message)
	  {
		  try {

			  Lamp temp = repository.findById(id).get();
			  JsonObject rq = new Gson().fromJson(message, JsonObject.class);
			  
			  String newStatus = rq.get("status").getAsString();
			  
			  System.out.println("Current lamp status: " + temp.getStatus());
			  System.out.println("Message status: " + newStatus);
			  
			  if(!temp.getStatus().equals(newStatus))
			  {
				  temp.setStatus(newStatus);
				  repository.save(temp);
				  mqttGateway.sendToMqtt(newStatus, "lamps/" + id + "/stato");
				  System.out.println("Lamp status changed to: " + newStatus);
				  return ResponseEntity.ok(new Gson().toJson("Eseguito l'update"));
			  }
			  else
			  {
				  System.out.println("Status unchanged");
				  return ResponseEntity.ok(new Gson().toJson("La lampadina è già in questo stato"));
			  }
		  }
		  catch(Exception ex)
		  {
			return ResponseEntity.ok(new Gson().toJson("Fallito l'update"));
		  }
	  }
	  
	  
	  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	  @PostMapping("/addLamps")
	  Lamp newLamp(@RequestBody Lamp newEmployee) {
		  
		mqttGateway.sendToMqtt("Inserisco nuova lampada", "out");
	    return repository.save(newEmployee);
	  }
}
