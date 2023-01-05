package com.SWEasabi.mqttdemo;

import org.springframework.data.jpa.repository.JpaRepository;

interface LampRepository extends JpaRepository<Lamp, Long> {

}