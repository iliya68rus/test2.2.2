package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {
    static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("Honda", "Red", 211));
        cars.add(new Car("Mazda", "Green", 137));
        cars.add(new Car("Nissan", "Blue", 421));
        cars.add(new Car("BMW", "Pink", 963));
        cars.add(new Car("Volkswagen", "Brown", 174));
    }

    public List<Car> getCars() {
        return cars;
    }

    public int numberOfCars() {
        return cars.size();
    }

    public Car getCarByNumber(int number) {
        return cars.get(number);
    }

}
