package project.ntsk.application.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.structure.NtskScheduler;

@Slf4j
@Component
public class SampleAScheduler extends NtskScheduler {

	@Scheduled(cron = "${application.scheduler.clock}")
	public void doSchedule() {

	}

}
