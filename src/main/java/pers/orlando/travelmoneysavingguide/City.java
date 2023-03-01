package pers.orlando.travelmoneysavingguide;

/**
 * Date: 2023/2/27
 * Author: liujiacheng
 */
public class City {
    private String cityName;
    private City[] to;

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                '}';
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public static City create(String cityName){
        return new City(cityName);
    }
}
