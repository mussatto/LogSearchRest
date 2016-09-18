package curupira.logsearch.controller;

public class CreateTriggerRequest {
	public CreateTriggerRequest(){};
	
	public CreateTriggerRequest(String query) {
		super();
		this.query = query;
	}

	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
