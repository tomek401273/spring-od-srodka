package com.kodilla.proxy.weather;

import java.util.Random;

public class WeatherSimple implements Weather {
    private String weather;
    private Random random= new Random();

    public WeatherSimple() {
        refreshData();
    }

    @Override
    public String getWeather(){
       return weather;
    }

    @Override
    public void refreshData(){
        System.out.println("refresh");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weather= String.valueOf(random.nextInt(100));
    }
}
