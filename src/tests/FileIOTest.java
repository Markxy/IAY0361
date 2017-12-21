import ForecastWeatherData.Result;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.OngoingStubbing;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileIOTest {



    @Before
    public void setUp() {
        Result result = mock(Result.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void readFile() throws IOException {
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.when(bufferedReader.readLine()).thenReturn("line1", "line2", "line3");

    }

    @Test
    public void writeToFile() {
        Result result = mock(Result.class);
        when(result.getList().size() > 29).thenThrow(Exception.class);
    }
}