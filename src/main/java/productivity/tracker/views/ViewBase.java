package productivity.tracker.views;

import productivity.tracker.presenters.PresenterBase;

public abstract class ViewBase<T extends PresenterBase<?, ?>> {

	private T presenter;

	public T getPresenter() {
		return presenter;
	}

	public void setPresenter(T presenter) {
		this.presenter = presenter;
	}

	public abstract void show();

	public abstract void hide();

	public abstract void dispose();

}
