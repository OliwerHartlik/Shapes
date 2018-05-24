package model;

public class MyRectangle extends MyShape {

	private int lengthOverY;

	private int lengthOverX;

	public MyRectangle(int cX, int cY, int x, int y, String c, boolean f) {
		super(cX, cY, c, f);
		lengthOverY = y;
		lengthOverX = x;

	}

	public int getLengthOverY() {
		return lengthOverY;
	}

	public void setLengthOverY(int lengthOverY) {
		this.lengthOverY = lengthOverY;
	}

	public int getLengthOverX() {
		return lengthOverX;
	}

	public void setLengthOverX(int lengthOverX) {
		this.lengthOverX = lengthOverX;
	}

	@Override
	public <V> V accept(MyShapeVisitor<V> visitor) {
		return visitor.visit(this);
	}

}
