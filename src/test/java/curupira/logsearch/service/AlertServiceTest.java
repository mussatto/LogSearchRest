package curupira.logsearch.service;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.curupira.index.FSLogIndexer;
import com.curupira.index.LogIndexer;

import curupira.logsearch.Config;
import curupira.logsearch.persistence.Alert;
import curupira.logsearch.persistence.AlertRepository;
import curupira.logsearch.persistence.LogTrigger;
import curupira.logsearch.persistence.TriggerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlertServiceTest {
	
	@Autowired
	AlertService alertService;
	
	@Autowired
	TriggerRepository triggerRepository;
	
	@Autowired
	AlertRepository alertRepository;
	
	public static final String SAMPLE_LOG = "/sample.log";
	
	@Test
	public void testRecreateAlerts() throws IOException{
        InputStream is = getClass().getResourceAsStream(SAMPLE_LOG);
        LogIndexer indexer = Config.getIndexer();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
            	indexer.indexLogLine(line, "sample.log");
            }
        }
        
        LogTrigger trigger = new LogTrigger();
        
        trigger.setQuery("SEVERE");
        
        triggerRepository.save(trigger);
        
		try {
			alertService.recreateAlerts();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		List<Alert> alerts = alertRepository.findAll();
		
		assertEquals(30, alerts.size());
		
		Config.deleteIndexer((FSLogIndexer) Config.getIndexer());
	}

}
