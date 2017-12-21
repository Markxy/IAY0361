import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class OWMQueryUrlTest {

    @Test
    public void getUnits() {
        OWMQueryUrl q = new OWMQueryUrl(true,"AAA", "xd");

        Assertions.assertEquals("forecast", q.getQueryType());
        Assertions.assertEquals("xd", q.getUnits());
        Assertions.assertEquals("AAA", q.getCityName());
    }

    @Test
    public void setUnits() {
        OWMQueryUrl q = new OWMQueryUrl(true,"AAA", "xd");

        Assertions.assertEquals("xd", q.getUnits());
        q.setUnits("metric");
        Assertions.assertEquals("metric", q.getUnits());
        q.setUnits("imperial");
        Assertions.assertEquals("imperial", q.getUnits());
    }

    @Test
    public void getCityName() {
        OWMQueryUrl q = new OWMQueryUrl(false,"Taklikaksdkasdasdad", "xd");

        Assertions.assertEquals("Taklikaksdkasdasdad", q.getCityName());

        OWMQueryUrl q2 = new OWMQueryUrl(false,"Paris", "xd");

        Assertions.assertEquals("Paris", q2.getCityName());
    }

    @Test
    public void setCityName() {

        OWMQueryUrl q = new OWMQueryUrl(false,"12321313", "xd");

        Assertions.assertEquals("12321313", q.getCityName());

        q.setCityName("ACD");

        Assertions.assertEquals("ACD", q.getCityName());

        q.setCityName("Tallinn");

        Assertions.assertEquals("Tallinn", q.getCityName());
    }
}