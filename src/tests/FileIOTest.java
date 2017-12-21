import ForecastWeatherData.Result;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.OngoingStubbing;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stubVoid;
import static org.mockito.Mockito.when;

public class FileIOTest {



    @Before
    public void setUp() throws Exception {
        Result result = mock(Result.class);


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readFile() throws IOException {

    }

    @Test
    public void writeToFile() {
    }
}