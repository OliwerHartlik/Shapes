package model;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import model.MyShape.MyShapeVisitor;

public class ToJson {
  public JsonArray listToJson(DataHolder data) {
	  List<MyShape> list=data.getAllShapes();
	  JsonArrayBuilder arrayBuilder=Json.createArrayBuilder();
	  for(MyShape shape:list) {
		  
		  JsonObjectBuilder builder=Json.createObjectBuilder();
		  
		    shape.accept(new MyShapeVisitor<Void>() {
		    	
		    	@Override
		    	public Void visit(MyRectangle myRectangle) {
		  		  builder.add("centerX", myRectangle.getCenterX());
				  builder.add("centerY", myRectangle.getCenterY());
				  builder.add("lengthOverX", myRectangle.getLengthOverX());
				  builder.add("lengthOverY", ((MyRectangle) shape).getLengthOverY());	
				  builder.add("type", "MyRectangle");
			    return null;
		    	}
		  

				@Override
				public Void visit(MyCircle myCircle) {
					  builder.add("centerX", shape.getCenterX());
					  builder.add("centerY", shape.getCenterY());
					  builder.add("radius", ((MyCircle) shape).getRadius());	
					  builder.add("type", "MyCircle");
				    return null;

				}

				@Override
				public Void visit(MyElipse myElipse) {
					  builder.add("centerX", shape.getCenterX());
					  builder.add("centerY", shape.getCenterY());
					  builder.add("lengthOverX", ((MyElipse) shape).getLengthOverX());
					  builder.add("lengthOverY", ((MyElipse) shape).getLengthOverY());	
					  builder.add("type", "MyElipse");
					return null;
				}

				@Override
				public Void visit(MyTriangle myTriangle) {
					  builder.add("firstX", ((MyTriangle)shape).getxPoint(0));
					  builder.add("firstY", ((MyTriangle)shape).getyPoint(0));
					  builder.add("secondX", ((MyTriangle)shape).getxPoint(1));
					  builder.add("secondY", ((MyTriangle)shape).getyPoint(1));
					  builder.add("thirdX", ((MyTriangle)shape).getxPoint(2));
					  builder.add("thirdY", ((MyTriangle)shape).getyPoint(2));
					  builder.add("type", "MyTriangle");
					return null;
				}
		    });

	  

		  builder.add("color", shape.getColor());
		  builder.add("fill", shape.isFill());
		  arrayBuilder.add(builder);
		  
	  }
	  return arrayBuilder.build();
  }
}
