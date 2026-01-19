package animalShelter.service;

import animalShelter.entity.User;
import animalShelter.repository.UserRepository;
import io.micrometer.observation.ObservationFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {          //Optional<User>
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {  //Optional<User>
        return userRepository.findByEmail(email);         // a ver si hay en repository
    }

    public User createUser(User user) {
        //  (email for ex.)
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));


        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}