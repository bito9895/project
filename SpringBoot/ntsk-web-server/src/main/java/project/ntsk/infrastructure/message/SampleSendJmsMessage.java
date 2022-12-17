package project.ntsk.infrastructure.message;

import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.ntsk.domain.model.entity.SampleAEntity;

@Component
public class SampleSendJmsMessage {

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public void query() {

		try {
			SampleAEntity entity = new SampleAEntity();
			String jsonObj = objectMapper.writeValueAsString(entity);
			jmsTemplate.send("TestQue", messageCreator -> {
				TextMessage message = messageCreator.createTextMessage();
				message.setText(jsonObj);
				return message;
			});
		} catch (Exception e) {

		}

	}

}
