package com.kodilla.proxy.weather;

public class WeatherProxy implements Weather{
    Weather weather;
    @Override
    public String getWeather() {
        if (weather!=null)
            return weather.getWeather();
        return "";
    }

    @Override
    public void refreshData() {
        if (weather==null)
            weather=new WeatherSimple();
        else
            weather.refreshData();
    }
}
