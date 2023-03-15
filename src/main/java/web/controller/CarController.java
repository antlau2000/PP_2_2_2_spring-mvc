package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
        carService.add(new Car("Hyundai", 123, "Thor"));
        carService.add(new Car("Ferrari", 777, "Loki"));
        carService.add(new Car("Volkswagen", 456, "Captain America"));
        carService.add(new Car("Mercedes", 854, "Tony Stark"));
        carService.add(new Car("BMW", 1, "Black Widow"));
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars;
        if (count != null) {
            cars = carService.listCarsLimitedByQuantity(count);
        } else {
            cars = carService.listCars();
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
