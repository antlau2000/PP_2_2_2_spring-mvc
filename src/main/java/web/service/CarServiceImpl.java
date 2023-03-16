package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Hyundai", 123, "Thor"));
        cars.add(new Car("Ferrari", 777, "Loki"));
        cars.add(new Car("Volkswagen", 456, "Captain America"));
        cars.add(new Car("Mercedes", 854, "Tony Stark"));
        cars.add(new Car("BMW", 1, "Black Widow"));
    }

    @Override
    public List<Car> listCarsLimitedByQuantity(Integer quantity) {
        if (quantity == null || quantity >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, quantity);
        }
    }
}
