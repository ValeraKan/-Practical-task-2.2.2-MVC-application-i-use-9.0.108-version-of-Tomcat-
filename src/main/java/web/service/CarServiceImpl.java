package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2020));
        cars.add(new Car("Honda", "Civic", 2019));
        cars.add(new Car("Ford", "Mustang", 2021));
        cars.add(new Car("BMW", "X5", 2022));
        cars.add(new Car("Audi", "A6", 2020));
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count >= 5) {
            return cars; // весь список
        } else if (count <= 0) {
            return new ArrayList<>(); // пустой список
        } else {
            return cars.subList(0, Math.min(count, cars.size()));
        }
    }
}

