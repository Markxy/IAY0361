import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class MockTests {
    private ForecastWeather forecastObjectMock;

    @Before
    public void setup(){}

    @Test
    public void getForecastObjectCityName(){
        forecastObjectMock = Mockito.mock(ForecastWeather.class);
        when(forecastObjectMock.getCityName()).thenReturn("Tallinn");

        String city = forecastObjectMock.getCityName();
        Assert.assertEquals(city, "Tallinn");
    }

}
