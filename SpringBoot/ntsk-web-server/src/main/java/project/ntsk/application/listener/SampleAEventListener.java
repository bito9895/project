package project.ntsk.application.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.structure.NtskEventListener;
import project.ntsk.domain.event.SampleUpdated;

@Slf4j
@Component
public class SampleAEventListener extends NtskEventListener {

	@EventListener
	public void updateSample(SampleUpdated event) {
	}

}
