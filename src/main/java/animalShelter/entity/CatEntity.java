package animalShelter.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cat")
@Data
public class CatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private String color;
    private int age;

}