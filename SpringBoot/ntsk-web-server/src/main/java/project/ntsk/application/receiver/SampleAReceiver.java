package project.ntsk.application.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.structure.NtskJmsReceiver;

@Slf4j
@Component
public class SampleAReceiver extends NtskJmsReceiver {

	private static final String MESSAGE_QUEUE = "TestQue";

	@JmsListener(destination = MESSAGE_QUEUE, containerFactory = "myFactory")
	public void receive(String message) {
		log.info("Message received(TestQue): {} ", message);

		log.info("Sleep 5000");
	}

}
