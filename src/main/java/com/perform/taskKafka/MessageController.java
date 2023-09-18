package com.perform.taskKafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/messages")
public class MessageController {

	private KafkaTemplate<String,MessageRequest> kafkaTemplate;
	
	public MessageController(KafkaTemplate<String,MessageRequest> kafkaTemplate) {
		this.kafkaTemplate= kafkaTemplate;
	}
	
	@PostMapping
	public void publish(@RequestBody MessageRequest request) {
		//test
		kafkaTemplate.send("taskTopic",request);
	}
}
