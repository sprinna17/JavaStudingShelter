package animalShelter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String address;
    private LocalDate registrationDate = LocalDate.now();

    @OneToMany(mappedBy = "requester", fetch = FetchType.LAZY)
    private List<AdoptionRequestEntity> adoptedDogs = new ArrayList<>();
    private String status = "ACTIVE"; //
}