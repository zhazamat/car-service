package kg_itschoolmegacom.carservice.service.impl;

import kg_itschoolmegacom.carservice.model.Car;
import kg_itschoolmegacom.carservice.repository.CarRepository;
import kg_itschoolmegacom.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
 @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car update(Car car) {

        return carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public List<Car> getRequestCost(double min, double max) {


        return carRepository.findAll()
                .stream()
                .filter(car -> car.getCost()>=min&&car.getCost()<=max)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getByName(String manufacturer) {

        return carRepository.findAll()
                .stream()
                .filter(car -> car.getManufacturer().toUpperCase(Locale.ROOT).equals(manufacturer.toUpperCase(Locale.ROOT)))
                .sorted(Comparator.comparingDouble(Car::getCost).reversed())
                .collect(Collectors.toList());
    }
}
