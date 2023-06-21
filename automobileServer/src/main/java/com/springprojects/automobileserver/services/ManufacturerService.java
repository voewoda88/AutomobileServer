package com.springprojects.automobileserver.services;

import com.springprojects.automobileserver.entities.ManufacturerEntity;
import com.springprojects.automobileserver.models.ManufacturerModel;
import com.springprojects.automobileserver.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ManufacturerService {
    @Autowired
    ManufacturerRepository manufacturerRepository;
    @Autowired
    ResponseService responseService;

    public ResponseEntity<String> addManufacturer(ManufacturerEntity manufacturer) {
        manufacturerRepository.save(manufacturer);
        return responseService.responseGeneration("Manufacturer successfully established", HttpStatus.OK);
    }

    public ResponseEntity<ManufacturerModel> getManufacturer(Long id) {
        return manufacturerRepository.findById(id)
                .map(manufacturer -> {
                    ManufacturerModel manufacturerModel = new ManufacturerModel();
                    manufacturerModel.assign(manufacturer);
                    return ResponseEntity.ok().body(manufacturerModel);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<String> putManufacturer(Long id, ManufacturerEntity manufacturer) {
        return manufacturerRepository.findById(id)
                .map(existingManufacturer -> {
                    if (!existingManufacturer.equals(manufacturer)) {
                        existingManufacturer.assign(manufacturer);
                        manufacturerRepository.save(existingManufacturer);
                        return responseService.responseGeneration("Manufacturer successfully modified", HttpStatus.OK);
                    }
                    else {
                        return responseService.responseGeneration("This manufacturer does not require modification", HttpStatus.BAD_REQUEST);
                    }
                })
                .orElse(responseService.responseGeneration("There is no such manufacturer", HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> deleteManufacturer(Long id) {
        return manufacturerRepository.findById(id)
                .map(manufacturer -> {
                    manufacturerRepository.delete(manufacturer);
                    return responseService.responseGeneration("Manufacturer successfully delete", HttpStatus.OK);
                })
                .orElse(responseService.responseGeneration("Manufacturer not found", HttpStatus.NOT_FOUND));
    }
}
