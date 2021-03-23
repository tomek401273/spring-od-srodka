package com.kodilla.proxy;

import com.kodilla.proxy.weather.Weather;
import com.kodilla.proxy.weather.WeatherProxy;
import com.kodilla.proxy.weather.WeatherSimple;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        Weather weather =
//                new WeatherSimple();
        new WeatherProxy();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            weather.getWeather();
            int number = random.nextInt(100);
            if (number < 20) {
                weather.refreshData();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }
}
