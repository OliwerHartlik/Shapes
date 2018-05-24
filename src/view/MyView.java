package view;

import java.util.List;

import model.MyShape;
import presenter.MyWindowPresenter;

public interface MyView {

	void setPresenter(MyWindowPresenter presenter);

	void initialize();

	void redrawShapes(List<MyShape> allShapes);
}
