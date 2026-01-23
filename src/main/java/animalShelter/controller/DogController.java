package animalShelter.controller;

import animalShelter.entity.DogEntity;
import animalShelter.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dog")
public class DogController {
    @Autowired
    private DogService dogService; // ya hay

    @GetMapping
    public List<DogEntity> getAllDogs() {
        return dogService.getAllDogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DogEntity> getDogById(@PathVariable Long id) {
        DogEntity dogEntity = dogService.getDogById(id);
        return ResponseEntity.ok(dogEntity);
    }

    @PostMapping
    public ResponseEntity<DogEntity> createDog(@RequestBody DogEntity dogEntity) {
        DogEntity created = dogService.createDog(dogEntity);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DogEntity> updateDog(@PathVariable Long id, @RequestBody DogEntity dogEntityDetails) {
        DogEntity updatedDogEntity = dogService.updateDog(id, dogEntityDetails);
        return ResponseEntity.ok(updatedDogEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return ResponseEntity.noContent().build();
    }
}