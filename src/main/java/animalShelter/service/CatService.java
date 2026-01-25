package animalShelter.service;

import animalShelter.entity.CatEntity;
import animalShelter.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatEntity> getAllCats() {
        return catRepository.findAll();
    }

    public CatEntity getCatById(Long id) {
        return catRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cat not found: " + id));
    }

    public CatEntity createCat(CatEntity catEntity) {
        catEntity.setId(null);
        return catRepository.save(catEntity);
    }

    public CatEntity updateCat(Long id, CatEntity catEntityDetails) {
        CatEntity existing = getCatById(id);

        existing.setName(catEntityDetails.getName());
        existing.setBreed(catEntityDetails.getBreed());
        existing.setColor(catEntityDetails.getColor());
        existing.setAge(catEntityDetails.getAge());

        return catRepository.save(existing);
    }

    public void deleteCat(Long id) {
        if (!catRepository.existsById(id)) {
            throw new RuntimeException("Cat not found: " + id);
        }
        catRepository.deleteById(id);
    }
}