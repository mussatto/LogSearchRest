package curupira.logsearch.persistence;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alert {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	private LogTrigger logTrigger;
	
	private Date dateCreated;
	
	private String loglineMatch;
	
	private String filename;
	
	private String lineNumber;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoglineMatch() {
		return loglineMatch;
	}

	public void setLoglineMatch(String loglineMatch) {
		this.loglineMatch = loglineMatch;
	}

	public LogTrigger getLogTrigger() {
		return logTrigger;
	}

	public void setLogTrigger(LogTrigger logTrigger) {
		this.logTrigger = logTrigger;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
}
