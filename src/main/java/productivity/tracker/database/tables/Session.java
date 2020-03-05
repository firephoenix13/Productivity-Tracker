package productivity.tracker.database.tables;

public class Session {

	public Session(int id, int eff, int startTime, int duration, int date) {
		sessionID = id;
		sessionEfficiency = eff;
		sessionStartTime = startTime;
		sessionDuration = duration;
		sessionDate = date;
	}

	private int sessionID;
	private int sessionEfficiency;
	private int sessionStartTime;
	private int sessionDuration;
	private int sessionDate;

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public int getSessionEfficiency() {
		return sessionEfficiency;
	}

	public void setSessionEfficiency(int sessionEfficiency) {
		this.sessionEfficiency = sessionEfficiency;
	}

	public int getSessionStartTime() {
		return sessionStartTime;
	}

	public void setSessionStartTime(int sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public int getSessionDuration() {
		return sessionDuration;
	}

	public void setSessionDuration(int sessionDuration) {
		this.sessionDuration = sessionDuration;
	}

	public int getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(int sessionDate) {
		this.sessionDate = sessionDate;
	}

}
