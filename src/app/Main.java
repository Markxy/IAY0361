import com.google.gson.*;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException{

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        String[] cities = FileIO.readFile(inputFile);


/*        System.out.println("Current temp is: " + CurrentWeather.getCurrentTemp(city));
        ForecastWeather fwth = new ForecastWeather(city);
        System.out.println(fwth.getForecastAsString());

        FileIO.writeToFile("output.txt","Current temp is: " + CurrentWeather.getCurrentTemp(city) + "\r\n" + fwth.getForecastAsString());
*/
        FileIO.deleteFileIfExists(outputFile);

        for (String city : cities) {
            ForecastWeather fwth = new ForecastWeather(city);
            FileIO.writeToFile(outputFile, "City: " + fwth.getCityName() + "\r\n" + fwth.getLatLngAsString() + "\r\n" + "Current temp is: " + CurrentWeather.getCurrentTemp(city) + "\r\n" + fwth.getForecastAsString());
        }


    }


}
