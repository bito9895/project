package project.ntsk.domain.event;

import project.ntsk.common.event.DomainEvent;

public class SampleAUpdated extends DomainEvent {

	public SampleAUpdated(Object source) {
		super(source);
	}
}
