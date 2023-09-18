package com.perform.taskKafka;

import java.util.Date;

public record MessageRequest(String taskId,String taskName,Date taskStartDt,
		Date taskEndDt,String taskStatus) {
	
	
}
