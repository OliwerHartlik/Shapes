package model;

public class MyTriangle extends MyShape {

	private int[] xPoints = new int[3];
	private int[] yPoints = new int[3];

	public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3, String c, boolean f) {
		super();
		color = c;
		fill = f;
		xPoints[0] = x1;
		xPoints[1] = x2;
		xPoints[2] = x3;
		yPoints[0] = y1;
		yPoints[1] = y2;
		yPoints[2] = y3;
	}

	public int[] getxPoints() {
		return xPoints;
	}

	public int getxPoint(int i) {
		return xPoints[i];
	}

	public void setxPoints(int[] xPoints) {
		this.xPoints = xPoints;
	}

	public int[] getyPoints() {
		return yPoints;
	}

	public int getyPoint(int i) {
		return yPoints[i];
	}

	public void setyPoints(int[] yPoints) {
		this.yPoints = yPoints;
	}

	@Override
	public <V> V accept(MyShapeVisitor<V> visitor) {
		return visitor.visit(this);
	}
}
