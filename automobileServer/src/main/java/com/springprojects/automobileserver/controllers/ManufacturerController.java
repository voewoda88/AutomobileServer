package com.springprojects.automobileserver.controllers;

import com.springprojects.automobileserver.entities.ManufacturerEntity;
import com.springprojects.automobileserver.models.ManufacturerModel;
import com.springprojects.automobileserver.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {
    @Autowired
    ManufacturerService manufacturerService;

    @PostMapping("/add")
    public ResponseEntity<String> createManufacturerController(@RequestBody ManufacturerEntity manufacturer) {
        return manufacturerService.addManufacturer(manufacturer);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ManufacturerModel> getManufacturerController(@PathVariable Long id) {
        return manufacturerService.getManufacturer(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putManufacturerController(@PathVariable Long id, @RequestBody ManufacturerEntity manufacturer) {
        return manufacturerService.putManufacturer(id, manufacturer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteManufacturerController(@PathVariable Long id) {
        return manufacturerService.deleteManufacturer(id);
    }
}
