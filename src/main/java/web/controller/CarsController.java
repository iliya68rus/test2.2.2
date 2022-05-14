package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {

        if (count == null) {
            model.addAttribute("cars", carService.getCars());
        } else {
            List<Car> list = new ArrayList<>();
            for (int i = 0; i < Math.min(carService.numberOfCars(), count); i++) {
                list.add(carService.getCarByNumber(i));
            }
            model.addAttribute("cars", list);
        }
        return "cars";
    }
}
