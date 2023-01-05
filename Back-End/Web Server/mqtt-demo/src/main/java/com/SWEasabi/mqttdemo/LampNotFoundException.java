package com.SWEasabi.mqttdemo;

class LampNotFoundException extends RuntimeException {

	  LampNotFoundException(Long id) {
	    super("Could not find lamp " + id);
	  }
	}