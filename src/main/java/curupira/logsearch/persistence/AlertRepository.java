package curupira.logsearch.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlertRepository extends CrudRepository<Alert, Long>{
	List<Alert> findAll();
}
