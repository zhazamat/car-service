package kg_itschoolmegacom.carservice.service;

import kg_itschoolmegacom.carservice.exceptions.MyResourceNotFoundException;
import kg_itschoolmegacom.carservice.model.Car;
import kg_itschoolmegacom.carservice.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public interface CarService {
   Car create(Car car);

   List<Car> getAllCars();

   Car update(Car car);

   void delete(Car car);

   List<Car> getRequestCost(double min,double max);

   List<Car> getByName(String manufacturer);
}

