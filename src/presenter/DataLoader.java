package presenter;

import java.io.FileInputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

import model.DataHolder;
import model.FromJson;

public class DataLoader {
	public static void load(DataHolder data) {
		try {
			  FromJson converter= new FromJson();
	          FileInputStream myInput= new FileInputStream("save.json");
	          JsonReader reader = Json.createReader(myInput);
	          JsonArray array=reader.readArray();
	          data.setAllShapes(converter.jsonToList(array));
	          myInput.close();
	          
		} catch ( IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
