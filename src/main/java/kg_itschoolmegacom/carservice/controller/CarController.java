package kg_itschoolmegacom.carservice.controller;

import kg_itschoolmegacom.carservice.exceptions.MyResourceNotFoundException;
import kg_itschoolmegacom.carservice.model.Car;
import kg_itschoolmegacom.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
private final CarService carService;
@Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping("/create")
    public Car create(@RequestBody Car car){
        return carService.create(car);
    }

    @GetMapping("/list")
    public List<Car> getAll(){
        return carService.getAllCars();
    }

    @PutMapping("/update")
    private Car update(@RequestBody Car car){
        return carService.update(car);
    }

    @DeleteMapping("/delete")
    private void delete(@RequestBody Car car)
    {
        carService.delete(car);
    }
    @GetMapping("/list/cost")
    public List<Car> getRequestCost(@RequestParam double min,@RequestParam double max){
    return carService.getRequestCost(min,max);
    }
    @GetMapping("/list/name")
    public List<Car> getByName(@RequestHeader String manufacturer){
     return carService.getByName(manufacturer);
    }
}
