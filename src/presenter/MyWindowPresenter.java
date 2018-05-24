package presenter;

import model.MyShape;

public interface MyWindowPresenter {

	void addShape(MyShape shape);

	void save();
	
	void load();
}
