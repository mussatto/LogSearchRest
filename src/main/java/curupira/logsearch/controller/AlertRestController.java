package curupira.logsearch.controller;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curupira.logsearch.persistence.Alert;
import curupira.logsearch.persistence.AlertRepository;
import curupira.logsearch.service.AlertService;

@RestController
@CrossOrigin
public class AlertRestController {

	@Autowired
	private AlertRepository alertRepository;

	@Autowired
	private AlertService alertService;

	@RequestMapping("/getAlerts")
	public List<Alert> getAlerts() {
		return alertRepository.findAll();
	}

	@RequestMapping("/refreshAlerts")
	public String refreshAlerts() {
		try {
			alertService.recreateAlerts();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			return "{'response':'error'}";
		}

		return "{'response':'ok'}";
	}
}
