package productivity.tracker.database.models;

public class SessionTemplate {

	// Unique ID from the database
	private int templateID;

	// The session templates name.
	private String templateName;

	// The session templates description.
	private String templateDescription;

	public SessionTemplate(int templateID, String templateName, String templateDescription) {
		this.templateID = templateID;
		this.templateName = templateName;
		this.templateDescription = templateDescription;
	}

	public SessionTemplate(String templateName, String templateDescription) {
		this.templateID = -1;
		this.templateName = templateName;
		this.templateDescription = templateDescription;
	}

	public int getTemplateID() {
		return templateID;
	}

	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateDescription() {
		return templateDescription;
	}

	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}

}
