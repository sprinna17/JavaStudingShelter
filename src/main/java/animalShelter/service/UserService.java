package animalShelter.service;

import animalShelter.dto.UserCreateRequestDto;
import animalShelter.dto.UserResponseDto;
import animalShelter.entity.UserEntity;
import animalShelter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDto create(UserCreateRequestDto dto) {
        UserEntity saved = userRepository.save(userMapper.toEntity(dto));
        return userMapper.toDto(saved);
    }

    public UserResponseDto getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserResponseDto update(Long id, UserCreateRequestDto dto) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        userMapper.updateEntity(entity, dto);
        return userMapper.toDto(userRepository.save(entity));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
