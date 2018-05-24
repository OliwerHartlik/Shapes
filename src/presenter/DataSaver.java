package presenter;


import java.io.FileOutputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonWriter;

import model.DataHolder;
import model.ToJson;

public class DataSaver {
	public static void save(DataHolder data) {
		try {
			  ToJson converter= new ToJson();
	          FileOutputStream myOutput= new FileOutputStream("save.json");
	          JsonWriter writer = Json.createWriter(myOutput);
	          JsonArray array=converter.listToJson(data);
	          writer.writeArray(array);
	          myOutput.close();
		} catch ( IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
