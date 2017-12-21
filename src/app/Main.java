import com.google.gson.*;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException{

        String city = FileIO.readFile("input.txt")[0];

        System.out.println("Current temp is: " + CurrentWeather.getCurrentTemp(city));
        ForecastWeather fwth = new ForecastWeather(city);
        System.out.println(fwth.getForecastAsString());

        FileIO.writeToFile("output.txt","Current temp is: " + CurrentWeather.getCurrentTemp(city) + fwth.getForecastAsString());


    }


}
