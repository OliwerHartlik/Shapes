package model;

import java.io.Serializable;

public abstract class MyShape implements Serializable {
	private int centerX;
	private int centerY;
	protected String color;
	protected boolean fill = false;
	private boolean painted = false;
	MyShape() {
	}

	MyShape(int cX, int cY, String c, boolean f) {
		centerX = cX;
		centerY = cY;
		color = c;
		fill = f;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isPainted() {
		return painted;
	}

	public void setPainted(boolean painted) {
		this.painted = painted;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public abstract <V> V accept(MyShapeVisitor<V> visitor);

	public interface MyShapeVisitor<V> {

		V visit(MyCircle myCircle);

		V visit(MyElipse myElipse);

		V visit(MyTriangle myTriangle);

		V visit(MyRectangle myRectangle);

	}
}
