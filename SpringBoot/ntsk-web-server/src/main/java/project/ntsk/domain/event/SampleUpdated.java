package project.ntsk.domain.event;

import project.ntsk.common.event.NtskEvent;

public class SampleUpdated extends NtskEvent {

	public SampleUpdated(Object source) {
		super(source);
	}
}
