package view;

import java.awt.Color;
import java.awt.event.*;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.*;
import model.*;
import presenter.DataLoader;
import presenter.MyWindowPresenter;
import presenter.DataSaver;
import view.ObjectCreationWindow.*;

public class Window implements MyView {

	JInternalFrame subFrame = new JInternalFrame();

	private MyWindowPresenter presenter;

	public Window() {
		//initialize();
	}

	@Override
	public void initialize() {

		JFrame mainFrame = new JFrame("Shapes");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton drawButton = new JButton("Draw");
		JButton saveButton = new JButton("Save");
		JButton loadButton = new JButton("Load");

		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPopupMenu menu = initializeMenu(mainFrame, drawButton, saveButton, loadButton);
				menu.show(drawButton, 30, 30);

			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.save();
			}
		});
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.load();
			}
		});

		drawButton.setBounds(20, 20, 80, 30);
		saveButton.setBounds(20, 650, 80, 30);
		loadButton.setBounds(20, 690, 80, 30);
		mainFrame.add(drawButton);
		mainFrame.add(saveButton);
		mainFrame.add(loadButton);
		mainFrame.setSize(1000, 800);
		subFrame.setBounds(200, 0, 800, 800);
		subFrame.setBackground(Color.white);
		((javax.swing.plaf.basic.BasicInternalFrameUI) subFrame.getUI()).setNorthPane(null);

		subFrame.setBorder(null);
		subFrame.setVisible(true);

		mainFrame.add(subFrame);

		mainFrame.add(drawButton);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);

	}

	public JPopupMenu initializeMenu(JFrame frame, JButton drawButton, JButton save, JButton load) {
		JPopupMenu menu = new JPopupMenu();
		JMenuItem rect = new JMenuItem("Rectangle");
		JMenuItem circle = new JMenuItem("Circle");
		JMenuItem elipse = new JMenuItem("Elipse");
		JMenuItem triangle = new JMenuItem("Triangle");
		menu.add(rect);
		menu.add(circle);
		menu.add(elipse);
		menu.add(triangle);
		ShapeReceiver receiver = new ShapeReceiver() {
			@Override
			public void onReceiveShape(MyShape shape) {
				presenter.addShape(shape);
			}
		};
		rect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new RectangleCreationWindow(frame, drawButton, save, load, subFrame, receiver);
				
			}
		});
		circle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new CircleCreationWindow(frame, drawButton, save, load, subFrame, receiver);
			}
		});
		elipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ElipseCreationWindow(frame, drawButton, save, load, subFrame, receiver);
			}
		});
		triangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new TriangleCreationWindow(frame, drawButton, save, load, subFrame, receiver);
			}
		});

		return menu;

	}

	@Override
	public void redrawShapes(List<MyShape> allShapes) {
		DrawMyComponent drawer = new DrawMyComponent(allShapes);
		subFrame.getContentPane().removeAll();

		subFrame.add(drawer);
		subFrame.validate();

		subFrame.repaint();
	}

	@Override
	public void setPresenter(MyWindowPresenter presenter) {
		this.presenter = presenter;
	}

}
