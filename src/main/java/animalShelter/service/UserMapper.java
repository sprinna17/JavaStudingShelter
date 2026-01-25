package animalShelter.service;

import animalShelter.dto.UserCreateRequestDto;
import animalShelter.dto.UserResponseDto;
import animalShelter.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(UserCreateRequestDto dto) {
        return UserEntity.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .build();
    }

    public UserResponseDto toDto(UserEntity entity) {
        return UserResponseDto.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .build();
    }

    public void updateEntity(UserEntity entity, UserCreateRequestDto dto) {
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
    }
}

