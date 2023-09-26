package com.example.test_work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/houses")
public class HouseController {
    @Autowired
    private HouseRepository houseRepository;
    
    
    @PostMapping
    public House createHouse(@RequestBody House house) {
        return houseRepository.save(house);
    }
    
    
    
    @GetMapping("/{id}")
    public Optional<House> getHouseById(@PathVariable Long id) {
        return houseRepository.findById(id);
    }
    
    
    @PutMapping("/{id}")
    public House updateHouse(@PathVariable Long id, @RequestBody House updatedHouse) {
        
        if (!houseRepository.existsById(id)) {
            throw new ResourceNotFoundException("House not found with id " + id);
        }
        updatedHouse.setId(id);
        return houseRepository.save(updatedHouse);
    }
    
    
    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable Long id) {
        
        if (!houseRepository.existsById(id)) {
            throw new ResourceNotFoundException("House not found with id " + id);
        }
        houseRepository.deleteById(id);
    }
}