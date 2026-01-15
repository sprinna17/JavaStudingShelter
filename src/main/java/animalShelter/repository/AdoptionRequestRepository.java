package animalShelter.repository;

import animalShelter.entity.AdoptionRequest;
import animalShelter.entity.AdoptionRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Long> {

    List<AdoptionRequest> findByRequesterId(Long userId);

    List<AdoptionRequest> findByDogId(Long dogId);

    List<AdoptionRequest> findByStatus(AdoptionRequestStatus status);
}