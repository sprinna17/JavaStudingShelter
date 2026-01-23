package animalShelter.repository;

import animalShelter.entity.AdoptionRequestEntity;
import animalShelter.AdoptionRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequestEntity, Long> {

    List<AdoptionRequestEntity> findByRequesterId(Long requesterId);

    List<AdoptionRequestEntity> findByDogId(Long dogId);

    List<AdoptionRequestEntity> findByStatus(AdoptionRequestStatus status);
}