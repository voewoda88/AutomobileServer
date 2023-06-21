package com.springprojects.automobileserver.controllers;

import com.springprojects.automobileserver.entities.CarEntity;
import com.springprojects.automobileserver.models.CarModel;
import com.springprojects.automobileserver.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarsControllers {
    @Autowired
    CarService carService;

    @PostMapping("/add")
    public ResponseEntity<String> addCarController(@RequestBody CarEntity car) {
        return carService.createCar(car);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CarModel> getCarController(@PathVariable Long id) {
        return carService.getCar(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putCarController(@PathVariable Long id, @RequestBody CarEntity car) {
        return carService.putCar(id, car);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCarController(@PathVariable Long id) {
        return carService.deleteCar(id);
    }

}
