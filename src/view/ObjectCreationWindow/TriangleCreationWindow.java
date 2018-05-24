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

import model.MyTriangle;





public class TriangleCreationWindow {
	public TriangleCreationWindow(JFrame frame, JButton drawButton, JButton save, JButton load,
			JInternalFrame subFrame, final ShapeReceiver receiver) {
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setGroupingUsed(false);
		drawButton.setEnabled(false);
		save.setBounds(-100, -100, 20, 20);
		load.setBounds(-100, -100, 10, 10);
		
		JPanel trianglePanel= new JPanel();
		trianglePanel.setBounds(0, 0, 200, 800);
		frame.add(trianglePanel);
		trianglePanel.grabFocus();
		
		JFormattedTextField firstPointX= new JFormattedTextField(format);
		firstPointX.setBounds(20, 100, 100, 30);
		trianglePanel.add(firstPointX);
		JFormattedTextField firstPointY= new JFormattedTextField(format);
		firstPointY.setBounds(20, 180, 100, 30);
		trianglePanel.add(firstPointY);
		JFormattedTextField secondPointX= new JFormattedTextField(format);
		secondPointX.setBounds(20, 260, 100, 30);
		trianglePanel.add(secondPointX);
		JFormattedTextField secondPointY= new JFormattedTextField(format);
		secondPointY.setBounds(20, 340, 100, 30);
		trianglePanel.add(secondPointY);
		JFormattedTextField thirdPointX= new JFormattedTextField(format);
		thirdPointX.setBounds(20, 420, 100, 30);
		trianglePanel.add(thirdPointX);
		JFormattedTextField thirdPointY= new JFormattedTextField(format);
		thirdPointY.setBounds(20, 500, 100, 30);
		trianglePanel.add(thirdPointY);

		
		JLabel firstXLabel=new JLabel("X coordinate of the first peak");
		firstXLabel.setBounds(20, 70, 170, 30);
		trianglePanel.add(firstXLabel);
		JLabel firstYLabel=new JLabel("Y coordinate of the first peak");
		firstYLabel.setBounds(20, 150, 170, 30);
		trianglePanel.add(firstYLabel);
		JLabel secondXLabel=new JLabel("X coordinate of the second peak");
		secondXLabel.setBounds(20, 230, 170, 30);
		trianglePanel.add(secondXLabel);
		JLabel secondYLabel=new JLabel("Y coordinate of the second peak");
		secondYLabel.setBounds(20, 310, 170, 30);
		trianglePanel.add(secondYLabel);
		JLabel thirdXLabel=new JLabel("X coordinate of the third peak");
		thirdXLabel.setBounds(20, 390, 170, 30);
		trianglePanel.add(thirdXLabel);
		JLabel thirdYLabel=new JLabel("Y coordinate of the third peak");
		thirdYLabel.setBounds(20, 470, 170, 30);
		trianglePanel.add(thirdYLabel);

		
		String[] colors= {"Red","Blue","Green"};
		JComboBox comboBox=new JComboBox(colors);
		comboBox.setBounds(20, 550, 100, 30);
		trianglePanel.add(comboBox);
		
		JCheckBox fillCheckBox= new JCheckBox("Fill");
		fillCheckBox.setBounds(20,630,100,30);
		trianglePanel.add(fillCheckBox);
		
		JButton addButton=new JButton("Add");
		addButton.setBounds(20,700,100,30);
		trianglePanel.add(addButton);
		addButton.addActionListener(new ActionListener(){
       	 public void actionPerformed(ActionEvent e) {
		       	 
		       	 
		       	 String fieldReader= firstPointX.getText();
		       	 int firstX=Integer.parseInt(fieldReader);
		       	 
		       	 fieldReader=firstPointY.getText();
		       	 int firstY=Integer.parseInt(fieldReader);
		       	 
		       	fieldReader=secondPointX.getText();
		       	 int secondX=Integer.parseInt(fieldReader);
		       	 
		       	fieldReader=secondPointY.getText();
		       	 int secondY=Integer.parseInt(fieldReader);
		       	 
		       	fieldReader=thirdPointX.getText();
		       	 int thirdX=Integer.parseInt(fieldReader);
		       	 
		       	 fieldReader=thirdPointY.getText();
		       	 int thirdY=Integer.parseInt(fieldReader);
		       	 
		       	 boolean fillCheck=fillCheckBox.isSelected();
		       	 
		       	 
		       	 String colorReader= (String) comboBox.getSelectedItem();
		       	 
			       	MyTriangle triangle= new MyTriangle(firstX, firstY, secondX,secondY,thirdX,thirdY, colorReader,fillCheck);
			       	receiver.onReceiveShape(triangle);
		       	
		       	
		       	
		       	trianglePanel.setVisible(false);
			    save.setBounds(20,650,80,30);
			    load.setBounds(20,690,80,30);
		       	drawButton.setEnabled(true);

       	 }
    		
		});
		frame.repaint();
	}
}

