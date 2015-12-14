import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class WriteToJson {

	public static void prepare() {
		
	}
	
	public static boolean save() throws IOException {

		Path path = Paths.get("myitemdef.json");
		File file = path.toFile();
		if (!file.exists()) {
			file.createNewFile();
		}
		try (FileWriter writer = new FileWriter(file)) {
			Gson builder = new GsonBuilder().setPrettyPrinting().create();
			JsonArray jsonArray = new JsonArray();
			JsonObject jsonObject = new JsonObject();

			jsonObject.addProperty("string1", "text1");
			jsonObject.addProperty("string2", "text2");
			jsonObject.addProperty("number1", 1);
			jsonArray.add(jsonObject);
			
			writer.write(builder.toJson(jsonArray));
			
			writer.close();
		} catch (IOException ex) {
			// logger.log(Level.SEVERE, "An error occured while trying to save a
			// player file.");
		}
		return true;
	}
}
