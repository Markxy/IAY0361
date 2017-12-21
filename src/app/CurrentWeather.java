import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

public class CurrentWeather {

    public static double getCurrentTemp(String cityName) throws IOException {
        OWMQueryUrl queryCurr = new OWMQueryUrl(false,cityName, "metric");
        JsonObject weatherReport = JsonFromUrl.get(queryCurr.toString());
        Gson gson = new Gson();
        CurrentWeatherData.Result dataCurr = gson.fromJson(weatherReport, CurrentWeatherData.Result.class);

        return dataCurr.getMain().getTemp();
    }
}
