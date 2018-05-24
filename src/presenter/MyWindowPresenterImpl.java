package presenter;

import model.DataHolder;
import model.MyShape;
import view.MyView;

public class MyWindowPresenterImpl implements MyWindowPresenter {

	private DataHolder dataHolder=new DataHolder();

	private MyView view;

	public MyWindowPresenterImpl(MyView view) {
		super();
		this.view = view;
		view.setPresenter(this);
		view.initialize();
		//load();
	}

	@Override
	public void addShape(MyShape shape) {
		dataHolder.addToAllShapes(shape);
		view.redrawShapes(dataHolder.getAllShapes());
	}

	@Override
	public void save() {
		DataSaver.save(dataHolder);
		view.redrawShapes(dataHolder.getAllShapes());
	}

	@Override
	public void load() {
		DataLoader.load(dataHolder);
		view.redrawShapes(dataHolder.getAllShapes());
	}

}
