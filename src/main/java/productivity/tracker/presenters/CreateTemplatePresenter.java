package productivity.tracker.presenters;

import productivity.tracker.database.TemplateSQLRepository;
import productivity.tracker.database.models.CreateTemplateModel;
import productivity.tracker.database.models.SessionTemplate;
import productivity.tracker.views.CreateTemplateView;

public class CreateTemplatePresenter extends PresenterBase<CreateTemplateView, CreateTemplateModel> {

	TemplateSQLRepository repo;

	public CreateTemplatePresenter(CreateTemplateView view) {
		super(view, new CreateTemplateModel());

		repo = new TemplateSQLRepository();

		getView().addCreateButtonListener(e -> onCreateButtonPressed());
		getView().addCancelButtonListener(e -> onCancelButtonPressed());
	}

	private void onCreateButtonPressed() {
		String name = getView().getTemplateName();
		String description = getView().getTemplateDescription();

		// TODO: Handle validation... i.e. no duplicate templates.

		SessionTemplate template = new SessionTemplate(name, description);
		repo.add(template);

		// TODO: Navigate back...
	}

	private void onCancelButtonPressed() {

	}

}