package curupira.logsearch.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TriggerRepository extends CrudRepository<LogTrigger, Long>{
	List<LogTrigger> findAll();
}
