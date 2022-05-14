package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {

    public List<Car> getCars();

    public int numberOfCars();

    public Car getCarByNumber(int number);
}
