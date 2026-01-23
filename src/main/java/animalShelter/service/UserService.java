package animalShelter.service;

import animalShelter.dto.UserCreateRequestDto;
import animalShelter.dto.UserResponseDto;
import animalShelter.entity.UserEntity;
import animalShelter.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto create(UserCreateRequestDto dto) {

        UserEntity userEntity = UserEntity.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .build();

        UserEntity saved = userRepository.save(userEntity);

        return UserResponseDto.builder()
                .id(saved.getId())
                .fullName(saved.getFullName())
                .email(saved.getEmail())
                .phone(saved.getPhone())
                .address(saved.getAddress())
                .build();
    }

    public UserResponseDto getById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        return UserResponseDto.builder()
                .id(userEntity.getId())
                .fullName(userEntity.getFullName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .address(userEntity.getAddress())
                .build();
    }

    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(userEntity -> UserResponseDto.builder()
                        .id(userEntity.getId())
                        .fullName(userEntity.getFullName())
                        .email(userEntity.getEmail())
                        .phone(userEntity.getPhone())
                        .address(userEntity.getAddress())
                        .build())
                .toList();
    }

    public UserResponseDto update(Long id, UserCreateRequestDto dto) {
        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        existing.setFullName(dto.getFullName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setAddress(dto.getAddress());

        UserEntity saved = userRepository.save(existing);

        return UserResponseDto.builder()
                .id(saved.getId())
                .fullName(saved.getFullName())
                .email(saved.getEmail())
                .phone(saved.getPhone())
                .address(saved.getAddress())
                .build();
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found: " + id);
        }
        userRepository.deleteById(id);
    }
}
