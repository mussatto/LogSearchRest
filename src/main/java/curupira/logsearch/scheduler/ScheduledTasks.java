package curupira.logsearch.scheduler;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import curupira.logsearch.service.AlertService;

@Component
public class ScheduledTasks {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
	private AlertService alertService;
	
	@Scheduled(fixedRate = 5000)
	public void findAlerts(){
		log.debug("m=findAlerts");
		try {
			alertService.recreateAlerts();
		} catch (IOException | ParseException e) {
			log.error(e.toString());
		}
	}
}
