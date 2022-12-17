package project.ntsk.common.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import project.ntsk.common.value.DateTime;

public abstract class NtskEvent extends ApplicationEvent {

	@Getter
	private DateTime dateTime = DateTime.now();

	public NtskEvent(Object source) {
		super(source);
	}

}
