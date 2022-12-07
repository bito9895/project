package project.ntsk.common.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import project.ntsk.common.value.DateTime;

@Getter
public abstract class DomainEvent extends ApplicationEvent {

	private DateTime dateTime = DateTime.now();

	public DomainEvent(Object source) {
		super(source);
	}

}
