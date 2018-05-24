package view.ObjectCreationWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.MyRectangle;

public class RectangleCreationWindow {
	public RectangleCreationWindow(JFrame frame, JButton drawButton, JButton save, JButton load,
			JInternalFrame subFrame, final ShapeReceiver receiver) {
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setGroupingUsed(false);
		drawButton.setEnabled(false);
		save.setBounds(-100, -100, 20, 20);
		load.setBounds(-100, -100, 10, 10);

		JPanel rectanglePanel = new JPanel();
		rectanglePanel.setBounds(0, 0, 200, 800);
		frame.add(rectanglePanel);
		rectanglePanel.grabFocus();

		JFormattedTextField centerXField = new JFormattedTextField(format);
		centerXField.setBounds(20, 100, 100, 30);
		rectanglePanel.add(centerXField);
		JFormattedTextField centerYField = new JFormattedTextField(format);
		centerYField.setBounds(20, 180, 100, 30);
		rectanglePanel.add(centerYField);
		JFormattedTextField xLength = new JFormattedTextField(format);
		xLength.setBounds(20, 260, 100, 30);
		rectanglePanel.add(xLength);
		JFormattedTextField yLength = new JFormattedTextField(format);
		yLength.setBounds(20, 340, 100, 30);
		rectanglePanel.add(yLength);

		JLabel centerXLabel = new JLabel("X coordinate of the center");
		centerXLabel.setBounds(20, 70, 150, 30);
		rectanglePanel.add(centerXLabel);
		JLabel centerYLabel = new JLabel("Y coordinate of the center");
		centerYLabel.setBounds(20, 150, 150, 30);
		rectanglePanel.add(centerYLabel);
		JLabel xLengthLabel = new JLabel("Width");
		xLengthLabel.setBounds(20, 230, 150, 30);
		rectanglePanel.add(xLengthLabel);
		JLabel yLengthLabel = new JLabel("Height");
		yLengthLabel.setBounds(20, 310, 150, 30);
		rectanglePanel.add(yLengthLabel);
		JLabel color = new JLabel("Color");
		color.setBounds(20, 390, 150, 30);
		rectanglePanel.add(color);

		String[] colors = { "Red", "Blue", "Green" };
		JComboBox comboBox = new JComboBox(colors);
		comboBox.setBounds(20, 420, 100, 30);
		rectanglePanel.add(comboBox);

		JCheckBox fillCheckBox = new JCheckBox("Fill");
		fillCheckBox.setBounds(20, 480, 100, 30);
		rectanglePanel.add(fillCheckBox);

		JButton addButton = new JButton("Add");
		addButton.setBounds(20, 700, 100, 30);
		rectanglePanel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fieldReader = centerXField.getText();
				int readCenterX = Integer.parseInt(fieldReader);

				fieldReader = centerYField.getText();
				int readCenterY = Integer.parseInt(fieldReader);

				fieldReader = xLength.getText();
				int readXLength = Integer.parseInt(fieldReader);

				fieldReader = yLength.getText();
				int readYLength = Integer.parseInt(fieldReader);
				boolean fillCheck = fillCheckBox.isSelected();

				String colorReader = (String) comboBox.getSelectedItem();

				rectanglePanel.setVisible(false);
				save.setBounds(20, 650, 80, 30);
				load.setBounds(20, 690, 80, 30);
				drawButton.setEnabled(true);

				MyRectangle rectangle = new MyRectangle(readCenterX, readCenterY, readXLength, readYLength, colorReader,
						fillCheck);
				receiver.onReceiveShape(rectangle);
			}

		});
		frame.repaint();
	}

}
