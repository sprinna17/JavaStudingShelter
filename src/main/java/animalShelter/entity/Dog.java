package animalShelter.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dogs")
@Data
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private String color;
    private int age;
//    private String status; // "available", "adopted"
}