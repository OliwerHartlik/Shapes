package model;

public class MyCircle extends MyShape {
	private int radius;

	public MyCircle(int cX, int cY, int r, String c, boolean f) {
		super(cX, cY, c, f);
		radius = r;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public <V> V accept(MyShapeVisitor<V> visitor) {
		return visitor.visit(this);
	}

}
