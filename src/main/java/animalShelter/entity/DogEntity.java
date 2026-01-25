package animalShelter.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dog")
@Data
public class DogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private String color;
    private int age;

}