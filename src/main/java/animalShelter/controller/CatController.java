package animalShelter.controller;

import animalShelter.entity.CatEntity;
import animalShelter.entity.DogEntity;
import animalShelter.service.CatService;
import animalShelter.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
public class CatController {
    @Autowired
    private CatService catService;

    @GetMapping
    public List<CatEntity> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatEntity> getCatById(@PathVariable Long id) {
        CatEntity catEntity = catService.getCatById(id);
        return ResponseEntity.ok(catEntity);
    }

    @PostMapping
    public ResponseEntity<CatEntity> createCat(@RequestBody CatEntity catEntity) {
        CatEntity created = catService.createCat(catEntity);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatEntity> updateCat(@PathVariable Long id, @RequestBody CatEntity catEntityDetails) {
        CatEntity updatedCatEntity = catService.updateCat(id, catEntityDetails);
        return ResponseEntity.ok(updatedCatEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
        return ResponseEntity.noContent().build();
    }
}