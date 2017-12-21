import com.google.gson.*;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException{

        System.out.println("Current temp is: " + CurrentWeather.getCurrentTemp("Tallinn"));

        int days = 3;

        String[][] temps = ForecastWeather.getForecastTemps("Tallinn");
        for (String[] temp : temps) {
            System.out.println("Day - " + temp[0] + " - min temp: " + temp[1] + ", max temp: " + temp[2]);
        }




    }


}
