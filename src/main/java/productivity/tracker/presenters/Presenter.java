package productivity.tracker.presenters;

import productivity.tracker.models.Model;
import productivity.tracker.views.View;

public class Presenter extends PresenterBase<View, Model> {

	public Presenter(View view, Model model) {
		super(view, model);
		getView().setPresenter(this);
	}

	public void onButtonClicked() {
		getModel().addOneToCount();
		getView().setLabelText(String.valueOf(getModel().getCount()));
	}
}