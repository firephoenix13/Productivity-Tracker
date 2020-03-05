package productivity.tracker.presenters;

import productivity.tracker.models.ModelBase;
import productivity.tracker.views.ViewBase;

public class PresenterBase<V extends ViewBase<?>, M extends ModelBase> {

	private V view;
	private M model;

	public PresenterBase(V view, M model) {
		this.view = view;
		this.model = model;
	}

	public V getView() {
		return view;
	}

	public M getModel() {
		return model;
	}

}
