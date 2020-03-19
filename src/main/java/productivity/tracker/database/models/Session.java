package productivity.tracker.database.models;

public class Session {

	// Unique ID from the database
	private int sessionID;

	// Unique template ID from the database
	private int templateID;

	// Start time of the session stored as a unix time integer.
	private int sessionStartTime;

	// End time of the session stored as a unix time integer.
	private int sessionEndTime;

	// Session perceived efficiency stored as an integer. 0 is the lowest efficiency
	// and 10 is the highest.
	private int sessionEfficiency;

	// Session perceived mood stored as an integer. 1 represents the mood neutral. 2
	// represents the mood happy.
	private int sessionMood;

	public Session(int sessionID, int templateID, int sessionStartTime, int sessionEndTime, int sessionEfficiency,
			int sessionMood) {
		this.sessionID = sessionID;
		this.templateID = templateID;
		this.sessionStartTime = sessionStartTime;
		this.sessionEndTime = sessionEndTime;
		this.sessionEfficiency = sessionEfficiency;
		this.sessionMood = sessionMood;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public int getTemplateID() {
		return templateID;
	}

	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}

	public int getSessionStartTime() {
		return sessionStartTime;
	}

	public void setSessionStartTime(int sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public int getSessionEndTime() {
		return sessionEndTime;
	}

	public void setSessionEndTime(int sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
	}

	public int getSessionEfficiency() {
		return sessionEfficiency;
	}

	public void setSessionEfficiency(int sessionEfficiency) {
		this.sessionEfficiency = sessionEfficiency;
	}

	public int getSessionMood() {
		return sessionMood;
	}

	public void setSessionMood(int sessionMood) {
		this.sessionMood = sessionMood;
	}

}
