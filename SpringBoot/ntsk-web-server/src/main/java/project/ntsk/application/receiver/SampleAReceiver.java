package project.ntsk.application.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SampleAReceiver {

	private static final String MESSAGE_QUEUE = "TestQue";

	@JmsListener(destination = MESSAGE_QUEUE, containerFactory = "myFactory")
	public void receive(String message) {
		log.info("Message received(TestQue): {} ", message);

		log.info("Sleep 5000");
	}

}
