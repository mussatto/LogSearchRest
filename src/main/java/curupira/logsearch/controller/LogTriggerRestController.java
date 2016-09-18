package curupira.logsearch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curupira.logsearch.persistence.LogTrigger;
import curupira.logsearch.persistence.TriggerRepository;

@RestController
@CrossOrigin
public class LogTriggerRestController {

	private static final Logger log = LoggerFactory.getLogger(LogTriggerRestController.class);
	@Autowired
	private TriggerRepository triggerRepository;

	@RequestMapping("/createTrigger")
	public String createTrigger(@RequestBody CreateTriggerRequest createTrigger) {
		log.debug("m=createTrigger,createTrigger=" + createTrigger);
		LogTrigger trigger = new LogTrigger();
		trigger.setQuery(createTrigger.getQuery());
		triggerRepository.save(trigger);
		return "{'response':'ok'}";

	}

	@RequestMapping("/deleteTrigger")
	public String deleteTrigger(@RequestBody Long id) {
		log.debug("m=deleteTrigger,id=" + id);
		triggerRepository.delete(id);
		return "{'response':'ok'}";
	}

	@RequestMapping("/getAllTriggers")
	public List<LogTrigger> getAll() {
		log.debug("m=getAll");
		return triggerRepository.findAll();
	}

	@RequestMapping("/updateTrigger")
	public String updateTrigger(@RequestParam(value = "query", defaultValue = "") String query,
			@RequestParam(value = "id", defaultValue = "0") Long id) {
		log.debug("m=updateTrigger,query=" + query + ",id=" + id);
		LogTrigger trigger = triggerRepository.findOne(id);
		trigger.setQuery(query);
		triggerRepository.save(trigger);
		return "{'response':'ok'}";

	}
}
