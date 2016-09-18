package curupira.logsearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import curupira.logsearch.service.AlertService;

@Configuration
public class AppConfig {

	@Bean
	public AlertService alertService(){
		return new AlertService();
	}
}
