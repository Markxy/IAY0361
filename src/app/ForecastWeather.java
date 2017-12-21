import ForecastWeatherData.Result;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Objects;

public class ForecastWeather {

    private static final int DAYS = 3;
    private static final int MIN_TEMP_INDEX = 1;
    private static final int MAX_TEMP_INDEX = 2;
    private static final int DATE_INDEX = 0;

    private String cityName;
    private int nrOfDays;
    private String[][] data;

    ForecastWeather(String cityName) throws IOException {
        this.cityName = cityName;

        String[][] temps = getForecastTemps(cityName);

        this.data = temps;
        this.nrOfDays = temps.length;

    }

    public String getForecastAsString(){
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < this.getNrOfDays(); i += 1){
            output.append(getDayForecastAsString(i)).append("\r\n");
        }
        return output.toString();
    }

    private String getDayForecastAsString(int dayNr){
        return "Day: " + this.getDayDate(dayNr) + " - min Temp: " + this.getMinTempOfDay(dayNr) + " max Temp: " + this.getMaxTempOfDay(dayNr);
    }

    private int getNrOfDays() {
        return this.nrOfDays;
    }

    private double getMaxTempOfDay(int dayNr){
        return Double.valueOf(this.data[dayNr][MAX_TEMP_INDEX]);
    }

    private double getMinTempOfDay(int dayNr){
        return Double.valueOf(this.data[dayNr][MIN_TEMP_INDEX]);
    }

    private String getDayDate(int dayNr){
        return this.data[dayNr][DATE_INDEX];
    }

    public String getCityName(){
        return this.cityName;
    }

    public void setCityNameAndUpdateData(String cityName) throws IOException {
        this.cityName = cityName;
        String[][] temps = getForecastTemps(cityName);

        this.data = temps;
        this.nrOfDays = temps.length;
    }

    private static String[][] getForecastTemps(String cityName) throws IOException {

        String[][] temps = new String[DAYS][3];
        Result data =  getForecastData(cityName);

        int i, j = 0;
        String currDay = data.getList().get(0).getDtTxt().split(" ")[0];
        double maxTemp = 0, minTemp = 0;
        for(i = 0; i < data.getList().size(); i += 1){
            if(!Objects.equals(data.getList().get(i).getDtTxt().split(" ")[0], currDay)){
                temps[j][MIN_TEMP_INDEX] = String.valueOf(minTemp);
                temps[j][MAX_TEMP_INDEX] = String.valueOf(maxTemp);
                temps[j][DATE_INDEX] = currDay;

                j += 1;
                if(j >= DAYS){
                    break;
                } else {
                    minTemp = 0;
                    maxTemp = 0;
                    currDay = data.getList().get(i).getDtTxt().split(" ")[0];
                }
            }

            if(isMaxTemp(data.getList().get(i).getMain().getTempMax(),maxTemp)) maxTemp = data.getList().get(i).getMain().getTempMax();
            if(isMinTemp(data.getList().get(i).getMain().getTempMin(),minTemp)) minTemp = data.getList().get(i).getMain().getTempMin();
        }

        return temps;
    }

    private static Result getForecastData(String cityName) throws IOException {

        OWMQueryUrl query = new OWMQueryUrl(true,cityName, "metric");

        JsonObject weatherReport = JsonFromUrl.get(query.toString());

        Gson gson = new Gson();

        return gson.fromJson(weatherReport, Result.class);
    }

    private static Boolean isMaxTemp(double curr, double max){
        return curr>max;
    }

    private static Boolean isMinTemp(double curr, double max){
        return curr<max;
    }

}
