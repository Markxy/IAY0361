import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class MockTests {
    private ForecastWeather forecastObjectMock;

    @Before
    public void setup(){}

    @Test
    public void getForecastObjectCityName(){
        forecastObjectMock = Mockito.mock(ForecastWeather.class);
        when(forecastObjectMock.getCityName()).thenReturn("Tallinn");

        Assert.assertEquals(forecastObjectMock.getCityName(), "Tallinn");
    }

    @Test
    public void getLatLngAsString() {
        forecastObjectMock = Mockito.mock(ForecastWeather.class);

        when(forecastObjectMock.getCityLatitude()).thenReturn(2.5);
        when(forecastObjectMock.getCityLongitude()).thenReturn(3.6);
        when(forecastObjectMock.getLatLngAsString()).thenCallRealMethod();


        Assert.assertEquals("Lat: 2.5 Lon: 3.6", forecastObjectMock.getLatLngAsString());
    }

}
