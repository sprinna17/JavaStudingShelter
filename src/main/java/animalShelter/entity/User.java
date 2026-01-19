package animalShelter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

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

    @OneToMany(mappedBy = "adopter", fetch = FetchType.LAZY)
    private List<Dog> adoptedDogs = new ArrayList<>();
    private String status = "ACTIVE"; //
}