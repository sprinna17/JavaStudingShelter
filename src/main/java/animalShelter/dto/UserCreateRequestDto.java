package animalShelter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class UserCreateRequestDto {

    @NotBlank String fullName;
    @Email String email;
    String phone;
    String address;

}
