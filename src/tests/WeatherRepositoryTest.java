import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by Mark on 01.10.2017.
 */
public class WeatherRepositoryTest {

    @Test
    public void testIfTempIsAcceptable(){
        try {
            double maxTemp = 50;
            double minTemp = -50;
            WeatherRequest request = new WeatherRequest("Tallinn", EE, metric);
            WeatherRepository repository = new WeatherRepository();

            WeatherReport report = repository.getWeather(request);

            assertTrue(minTemp < report.temperature && report.temperature < maxTemp);
        }catch(Exception e){
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfRequestedCityEqualsResponseCity(){
        try{
            WeatherRequest request = new WeatherRequest("Tallinn", EE, metric);
            WeatherRepository repository = new WeatherRepository();

            WeatherReport report = repository.getWeather(request);

            assertEquals(report.cityName,request.cityName);
        }catch(Exception e){
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfRequestedTempFormatEqualsResponseTempFormat(){
        try{
            WeatherRequest request = new WeatherRequest("Tallinn", EE, metric);
            WeatherRepository repository = new WeatherRepository();

            WeatherReport report = repository.getWeather(request);

            assertEquals(report.tempFormat,request.tempFormat);
        }catch(Exception e){
            fail("Failure cause: " + e.getMessage());
        }
    }

}
