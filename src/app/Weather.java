import CurrentWeatherData.Result;
import com.google.gson.*;

import java.io.IOException;

public class Weather {

    public static void main(String args[]) throws IOException{
        Query query = new Query(false,"Tallinn", "metric");

        String apiUrl = query.toString();

        System.out.println(apiUrl);

        JsonObject weatherReport = Url.getJsonFromUrl(apiUrl);

        Gson gson = new Gson();
        Result data = gson.fromJson(weatherReport, Result.class);
        System.out.println(data.getMain().getTemp());

        System.out.println(weatherReport.get("main"));
        System.out.println(weatherReport.toString());

    }


}
