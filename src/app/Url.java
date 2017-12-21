import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Url {
    public static JsonObject getJsonFromUrl(String url) throws IOException{
        JsonObject content;
        URL urlObj = new URL(url);
        HttpURLConnection request = (HttpURLConnection) urlObj.openConnection();
        request.connect();

        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        content = root.getAsJsonObject(); //May be an array, may be an object.

        return content;
    }

}
