package com.perform.taskKafka;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@Component
public class KafkaListeners {
	
	private static final Logger logger = LogManager.getLogger(KafkaListeners.class);
	@Autowired
	RestTemplate resttmpl;
	
	@Value("${task.uri}")
	String URI;
	
	
	@KafkaListener(
		topics="taskTopic",
		groupId="group1"
	 )
	

	void listener( String data) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Task msgReq = mapper.readValue(data, Task.class);
		System.out.println("Listener Received: "+msgReq.toString() );
		executeTaskWithMongoAPI(msgReq);
	}

	private void executeTaskWithMongoAPI(Task data) {
		String methodName = "executeTaskWithMongoAPI";
		data.setTaskStatus("Complete");
		data.setTaskEndDt(new Date());
		ResponseEntity<Task> savedTask = resttmpl.postForEntity(URI+"/createTask", data, Task.class);
		logger.info(methodName,"Task updated Successfully"+savedTask);
	}

}
