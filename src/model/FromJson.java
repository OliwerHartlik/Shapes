package model;

import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class FromJson {
	public ArrayList<MyShape> jsonToList(JsonArray array) {
		ArrayList<MyShape> list = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			JsonObject object = array.getJsonObject(i);
			String type = object.getString("type");
			if (type.equals("MyTriangle")) {
				int firstX = object.getInt("firstX");
				int firstY = object.getInt("firstY");
				int secondX = object.getInt("secondX");
				int secondY = object.getInt("secondY");
				int thirdX = object.getInt("thirdX");
				int thirdY = object.getInt("thirdY");
				String color = object.getString("color");
				boolean fill = object.getBoolean("fill");
				MyTriangle rectangle = new MyTriangle(firstX, firstY, secondX, secondY, thirdX, thirdY, color, fill);
				list.add(rectangle);
			} 
			else {
				int centerX = object.getInt("centerX");
				int centerY = object.getInt("centerY");
				String color = object.getString("color");
				boolean fill = object.getBoolean("fill");
				if (type.equals("MyRectangle")) {
					int lengthOverX = object.getInt("lengthOverX");
					int lengthOverY = object.getInt("lengthOverY");
					MyRectangle shape = new MyRectangle(centerX, centerY, lengthOverX, lengthOverY, color, fill);
					list.add(shape);
				}
				if (type.equals("MyCircle")) {
					int radius = object.getInt("radius");
					MyCircle circle = new MyCircle(centerX, centerY, radius, color, fill);
					list.add(circle);
				}
				if (type.equals("MyElipse")) {
					int lengthOverX = object.getInt("lengthOverX");
					int lengthOverY = object.getInt("lengthOverY");
					MyElipse shape = new MyElipse(centerX, centerY, lengthOverX, lengthOverY, color, fill);
					list.add(shape);
				}
			}
		}
		return list;
	}
}
