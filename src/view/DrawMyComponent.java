package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.text.html.StyleSheet;

import model.*;
import model.MyShape.MyShapeVisitor;

public class DrawMyComponent extends JPanel {

	private List<MyShape> secondList= new ArrayList<>();
	public DrawMyComponent(List<MyShape> list) {
		this.secondList.addAll(list);
		
	}

	  public void paintComponent(Graphics g) {
		  //super.paintComponent(g);
		  StyleSheet s= new StyleSheet();

		  for(MyShape shape: secondList) {
			  
			   Color c= s.stringToColor(shape.getColor());
			    g.setColor(c);
				    shape.accept(new MyShapeVisitor<Void>() {
				    	@Override
				    	public Void visit(MyRectangle myRectangle) {
					    if(myRectangle.isFill()) {
					    g.fillRect(myRectangle.getCenterX()-(myRectangle.getLengthOverX()/2),myRectangle.getCenterY()-(myRectangle.getLengthOverY()/2),myRectangle.getLengthOverX(),myRectangle.getLengthOverY());
					    }else {
					    g.drawRect(myRectangle.getCenterX()-(myRectangle.getLengthOverX()/2),myRectangle.getCenterY()-(myRectangle.getLengthOverY()/2),myRectangle.getLengthOverX(),myRectangle.getLengthOverY());
					    }
					    return null;
				    	}
				  

						@Override
						public Void visit(MyCircle myCircle) {
					    	if(myCircle.isFill()) {
						    g.fillOval(myCircle.getCenterX()-myCircle.getRadius(),myCircle.getCenterY()-myCircle.getRadius(),myCircle.getRadius()*2,myCircle.getRadius()*2);
						    }else {
						    g.drawOval(myCircle.getCenterX()-myCircle.getRadius(),myCircle.getCenterY()-myCircle.getRadius(),myCircle.getRadius()*2,myCircle.getRadius()*2);
						    }
						    return null;

						}

						@Override
						public Void visit(MyElipse myElipse) {
				    		if(myElipse.isFill()) {
			    			g.fillOval(myElipse.getCenterX()-myElipse.getLengthOverX()/2,myElipse.getCenterY()-myElipse.getLengthOverY()/2,myElipse.getLengthOverX(),myElipse.getLengthOverY());
			    		}else {
						    g.drawOval(myElipse.getCenterX()-myElipse.getLengthOverX()/2,myElipse.getCenterY()-myElipse.getLengthOverY()/2,myElipse.getLengthOverX(),myElipse.getLengthOverY());

			    		}
							return null;
						}

						@Override
						public Void visit(MyTriangle myTriangle) {
				    		if(myTriangle.isFill()) {
			    			g.fillPolygon(myTriangle.getxPoints(),myTriangle.getyPoints(),3);
			    		}else {
						    g.drawPolygon(myTriangle.getxPoints(),myTriangle.getyPoints(),3);

			    		}
							return null;
						}  	

		  });
			
		  }
	  }
}

