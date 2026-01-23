package animalShelter.dto;

import lombok.Builder;
import lombok.Value;
import java.util.UUID;

@Value
@Builder
public class UserResponseDto {
    Long id;
    String fullName;
    String email;
    String phone;
    String address;
}
