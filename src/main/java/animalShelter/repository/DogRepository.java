package animalShelter.repository;

import animalShelter.entity.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<DogEntity, Long> {
}
