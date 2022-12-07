package project.ntsk.application.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SampleAScheduler {

	@Scheduled(cron = "${application.scheduler.clock}")
	public void doSchedule() {

	}

}
