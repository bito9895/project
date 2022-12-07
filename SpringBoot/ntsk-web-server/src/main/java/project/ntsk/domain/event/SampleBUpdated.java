package project.ntsk.domain.event;

import project.ntsk.common.event.DomainEvent;

public class SampleBUpdated extends DomainEvent {

	public SampleBUpdated(Object source) {
		super(source);
	}
}
