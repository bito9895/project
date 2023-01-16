package project.ntsk.domain.value;

import java.util.EnumMap;
import java.util.Map;

public class EventType {

	private Map<EventID, Boolean> collection = new EnumMap<>(EventID.class);

	public EventType() {
		collection = new EnumMap<>(EventID.class);
		for (EventID eventID : EventID.getAll()) {
			collection.put(eventID, false);
		}
	}

	public void set(EventID eventID) {
		collection.put(eventID, true);
	}

	public boolean isEvent1() {
		return collection.get(EventID.NTSK);
	}

}
