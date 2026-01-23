package animalShelter.service;

import animalShelter.entity.DogEntity;
import animalShelter.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<DogEntity> getAllDogs() {
        return dogRepository.findAll();
    }

    public DogEntity getDogById(Long id) {
        return dogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dog not found: " + id));
    }

    public DogEntity createDog(DogEntity dogEntity) {
        dogEntity.setId(null);
        return dogRepository.save(dogEntity);
    }

    public DogEntity updateDog(Long id, DogEntity dogEntityDetails) {
        DogEntity existing = getDogById(id);

        existing.setName(dogEntityDetails.getName());
        existing.setBreed(dogEntityDetails.getBreed());
        existing.setColor(dogEntityDetails.getColor());
        existing.setAge(dogEntityDetails.getAge());

        return dogRepository.save(existing);
    }

    public void deleteDog(Long id) {
        if (!dogRepository.existsById(id)) {
            throw new RuntimeException("Dog not found: " + id);
        }
        dogRepository.deleteById(id);
    }
}