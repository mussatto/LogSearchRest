package curupira.logsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curupira.logsearch.persistence.LogTrigger;
import curupira.logsearch.persistence.TriggerRepository;

@RestController
@CrossOrigin
public class TriggerRestController {
	
	@Autowired
	private TriggerRepository triggerRepository;
	
	@RequestMapping("/createTrigger")
	public String createTrigger(@RequestParam(value="query", defaultValue="") String query){
		LogTrigger trigger = new LogTrigger();
		trigger.setQuery(query);
		
		triggerRepository.save(trigger);
		
		return "";
		
	}
}
