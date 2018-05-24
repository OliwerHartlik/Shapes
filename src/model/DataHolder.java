package model;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
	private List<MyShape> allShapes= new ArrayList<>();

	public List<MyShape> getAllShapes() {
		return allShapes;
	}

	public void setAllShapes(List<MyShape> allShapes) {
		this.allShapes = allShapes;
	}
	public void addToAllShapes(MyShape shape) {
	  allShapes.add(shape);
	}

}
