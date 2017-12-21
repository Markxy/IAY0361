import java.util.Optional;

public class OWMQueryUrl {

    private String queryPrefix = "http://api.openweathermap.org/data/2.5/";
    public String isForecast;
    private String queryType;
    private String units;
    private String cityName;
    private String apiKey = "&APPID=384b79db758d750f0508627750c67c44";


    OWMQueryUrl(Boolean isForecast, String cityName, String units){

        if(isForecast){
            this.queryType = "forecast";
        } else {
            this.queryType = "weather";
        }

        this.cityName =  cityName;
        this.units =  units;

    }

    public String getQueryType() {
        return queryType;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    public String toString(){
        return queryPrefix + this.queryType + "?q=" + this.cityName + "&units=" + this.units + apiKey;
    }
}
