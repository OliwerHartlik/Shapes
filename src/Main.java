import presenter.*;
import view.MyView;
import view.Window;

public class Main {
	public static void main(String []args) {
		MyView view = new Window();
		MyWindowPresenter presenter = new MyWindowPresenterImpl(view);
	}
}
