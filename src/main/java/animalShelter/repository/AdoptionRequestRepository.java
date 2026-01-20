package animalShelter.repository;

import animalShelter.entity.AdoptionRequest;
import animalShelter.AdoptionRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Long> {

    List<AdoptionRequest> findByRequesterId(Long requesterId);

    List<AdoptionRequest> findByDogId(Long dogId);

    List<AdoptionRequest> findByStatus(AdoptionRequestStatus status);
}