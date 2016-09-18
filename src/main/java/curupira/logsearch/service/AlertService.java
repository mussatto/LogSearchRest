package curupira.logsearch.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curupira.document.LogSearchDocument;
import com.curupira.search.LogSearch;

import curupira.logsearch.Config;
import curupira.logsearch.persistence.Alert;
import curupira.logsearch.persistence.AlertRepository;
import curupira.logsearch.persistence.LogTrigger;
import curupira.logsearch.persistence.TriggerRepository;

@Component
public class AlertService {
	
	@Autowired
	private AlertRepository alertRepository;
	
	@Autowired
	private TriggerRepository triggerRepository;
	
	public void recreateAlerts() throws IOException, ParseException{
		List<Alert> alerts = alertRepository.findAll();
		alertRepository.delete(alerts);
		alerts = new ArrayList<Alert>();
		List<LogTrigger> triggers = triggerRepository.findAll();
		
		for(LogTrigger trigger : triggers){
			LogSearch logSearch = Config.getSearcher();
			
			List<LogSearchDocument> searchResults = logSearch.searchString(trigger.getQuery());
			
			
			for(LogSearchDocument result : searchResults){
				Alert alert = new Alert();
				alert.setLogTrigger(trigger);
				alert.setLoglineMatch(result.getLog());
				alert.setFilename(result.getFilename());
				alert.setLineNumber(result.getLogLineNumber());
				alerts.add(alert);
			}
			
		}
		
		alertRepository.save(alerts);
	}
	
}
