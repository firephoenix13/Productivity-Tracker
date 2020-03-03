package productivity.tracker.presenters;

import productivity.tracker.interfaces.ViewListener;
import productivity.tracker.models.Model;
import productivity.tracker.views.View;

public class Presenter extends PresenterBase<View, Model> implements ViewListener {

	public Presenter(View view, Model model) {
		super(view, model);
		getView().setPresenter(this);
	}

	@Override
	public void onButtonClicked() {
		getModel().addOneToCount();
		getView().setLabelText(String.valueOf(getModel().getCount()));
	}
}