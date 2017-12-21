import java.util.Optional;

public class Query {

    private String queryPrefix = "http://api.openweathermap.org/data/2.5/";
    public String isForecast;
    private String queryType;
    private String units;
    private String cityName;
    private String apiKey = "&APPID=384b79db758d750f0508627750c67c44";


    Query(Boolean isForecast, String cityName, String units){

        if(isForecast){
            this.queryType = "forecast";
        } else {
            this.queryType = "weather";
        }

        this.cityName = "?q=" + cityName;
        this.units = "&" + "units=" + units;

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
        return queryPrefix + this.queryType + this.cityName + this.units + apiKey;
    }
}
