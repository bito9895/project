package project.ntsk.application.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import project.ntsk.domain.event.SampleAUpdated;

@Component
public class SampleAEventListener {

	@EventListener
	public void updateSample(SampleAUpdated event) {
	}

}
