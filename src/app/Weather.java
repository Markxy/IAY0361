import com.google.gson.*;

import java.io.IOException;

public class Weather {

    public static void main(String args[]) throws IOException{
        String prefix = "http://api.openweathermap.org/data/2.5/";
        String queryType = "weather?q=";
        String city = "Tallinn";
        String apiPrefix = "&APPID=";
        String apiKey = "384b79db758d750f0508627750c67c44";

        String apiUrl = prefix + queryType + city + apiPrefix + apiKey;

        JsonObject weatherReport = Url.getJsonFromUrl(apiUrl);

        System.out.println(weatherReport.get("main"));
        System.out.println(weatherReport.toString());

        JsonObject result = weatherReport.getAsJsonObject("weather");
        System.out.println(result.toString());

        String result2 = result.get("main").toString();
        System.out.println(result2);
    }


}
