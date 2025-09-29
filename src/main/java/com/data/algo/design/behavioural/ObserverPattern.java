package com.data.algo.design.behavioural;

import java.util.ArrayList;
import java.util.List;

// Observer Pattern
interface Observer {
    void update(float temperature, float humidity);
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class WeatherData implements Subject {

    private List<Observer> observers ;
    private float temperature;
    private float humidity;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update(humidity, temperature);
        }
    }

    // When measurements change
    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }
}

class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;

    @Override
    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "°C and " + humidity + "% humidity");
    }
}

class PreviousConditions implements Observer {
    private float temperature;
    private float humidity;

    @Override
    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Previous conditions: " + temperature + "°C and " + humidity + "% humidity");
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        PreviousConditions previousConditions = new PreviousConditions();

        weatherData.registerObserver(currentConditionsDisplay);
        weatherData.registerObserver(previousConditions);
        weatherData.setMeasurements(27.7f, 33.0f);
        weatherData.setMeasurements(27.7f, 32.0f);
        weatherData.setMeasurements(21.4f, 32.0f);
    }
}
