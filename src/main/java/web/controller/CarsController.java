package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda", "Red", 211));
        cars.add(new Car("Mazda", "Green", 137));
        cars.add(new Car("Nissan", "Blue", 421));
        cars.add(new Car("BMW", "Pink", 963));
        cars.add(new Car("Volkswagen", "Brown", 174));
        if (count == null) {
            model.addAttribute("cars", cars);
        } else {
            List<Car> list = new ArrayList<>();
            for (int i = 0; i < Math.min(cars.size(), count); i++) {
                list.add(cars.get(i));
            }
            model.addAttribute("cars", list);
        }
        return "cars";
    }
}
