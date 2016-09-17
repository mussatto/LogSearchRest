package curupira.logsearch.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TriggerRepositoryTest {
	
	@Autowired
	TriggerRepository triggerRepository;
	
	@Test
	public void testSave(){
		LogTrigger newTrigger = new LogTrigger();
		newTrigger.setQuery("ERROR");
		
		triggerRepository.save(newTrigger);
	}

}
