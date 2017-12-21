import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

import static org.junit.Assert.*;

public class ForecastWeatherTest {

    @Test
    public void getCityLatitude() {
        try {
            String[] cities = {"Tallinn", "Milan", "Paris", "New York"};
            for(String city : cities) {
                ForecastWeather fc = new ForecastWeather(city);
                Assertions.assertTrue(Math.abs(fc.getCityLatitude()) <=  90);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCityName() {
        try {
            String[] cities = {"Tallinn", "Milan", "Paris", "New York", "Toronto", "Hong Kong"};
            for(String city : cities) {
                ForecastWeather fc = new ForecastWeather(city);
                Assertions.assertEquals(fc.getCityName(),city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}