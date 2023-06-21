package com.springprojects.automobileserver.services;

import com.springprojects.automobileserver.entities.CarEntity;
import com.springprojects.automobileserver.entities.ManufacturerEntity;
import com.springprojects.automobileserver.models.CarModel;
import com.springprojects.automobileserver.repositories.CarRepository;
import com.springprojects.automobileserver.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("singleton")
public class CarService {
    @Autowired
    ManufacturerRepository manufacturerRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    ResponseService responseService;
    public ResponseEntity<String> createCar(CarEntity car) {
        Optional<ManufacturerEntity> temp = manufacturerRepository.findById(car.getManufacturer().getId());
        if(temp.isPresent()) {
            car.setManufacturer(temp.get());
            carRepository.save(car);
            return responseService.responseGeneration("Car was saved successfully", HttpStatus.OK);
        }
        else {
            return responseService.responseGeneration("There is no such manufacturer", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<CarModel> getCar(Long id) {
        Optional<CarEntity> optionalCarModel = carRepository.findById(id);
        if (optionalCarModel.isPresent()) {
            CarModel car = new CarModel();
            car.assign(optionalCarModel.get());
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> putCar(Long id, CarEntity car) {
        Optional<CarEntity> optionalCarModel = carRepository.findById(id);
        if(optionalCarModel.isPresent()) {
            CarEntity existingCar = optionalCarModel.get();
            if(!existingCar.equals(car)) {
                existingCar.assign(car);
                carRepository.save(existingCar);
                return responseService.responseGeneration("Car successfully modified", HttpStatus.OK);
            }
            else {
                return responseService.responseGeneration("This car does not require modification", HttpStatus.BAD_REQUEST);
            }
        }
        else {
            return responseService.responseGeneration("There is no such car", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteCar(Long id) {
        Optional<CarEntity> optionalCarModel = carRepository.findById(id);
        if(optionalCarModel.isPresent()) {
            carRepository.delete(optionalCarModel.get());
            return responseService.responseGeneration("Car successfully delete", HttpStatus.OK);
        }
        else {
            return responseService.responseGeneration("Car not found", HttpStatus.NOT_FOUND);
        }
    }
}
