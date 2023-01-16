package project.ntsk.common.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Async
@AllArgsConstructor
@Component
public class NtskPublisher {

	private final ApplicationEventPublisher publisher;

	public void publishEvent(NtskEvent domain) {
		publisher.publishEvent(domain);
	}

}
