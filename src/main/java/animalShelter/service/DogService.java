package animalShelter.service;

import animalShelter.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DogService {

    private final Map<Long, Dog> dogMap = new ConcurrentHashMap<>();
    private long nextId = 1L;

    public List<Dog> getAllDogs() {
        return new ArrayList<>(dogMap.values());
    }

    public Optional<Dog> getDogById(Long id) {
        return Optional.ofNullable(dogMap.get(id));
    }

    public Dog createDog(Dog dog) {
        if (dog.getId() != null) {
            throw new IllegalArgumentException("Perro sin ID todavía");
        }
        long newId = nextId++;
        dog.setId(newId);
        dogMap.put(newId, dog);
        return dog;
    }

    public Dog updateDog(Long id, Dog dogDetails) {
        if (!dogMap.containsKey(id)) {
            throw new RuntimeException("No encontrado el perro con id: " + id);
        }
        dogDetails.setId(id);
        dogMap.put(id, dogDetails);
        return dogDetails;
    }

    public void deleteDog(Long id) {
        dogMap.remove(id);
    }
}
