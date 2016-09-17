package curupira.logsearch.persistence;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlertRepositoryTest {
	
	@Autowired
	AlertRepository alertRepository;
	
	@Autowired
	TriggerRepository triggerRepository;
	
	@Test
	public void testSave(){
		LogTrigger newTrigger = new LogTrigger();
		newTrigger.setQuery("ERROR");
		
		newTrigger = triggerRepository.save(newTrigger);
		
		Alert alert = new Alert();
		
		alert.setDateCreated(new java.sql.Date(new Date().getTime()));
		alert.setLogTrigger(newTrigger);
		
		alertRepository.save(alert);
		
		List<Alert> alerts = alertRepository.findAll();
		
		Assert.assertNotEquals(alerts.size(), 0);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+alerts.size());
		
	}

}
