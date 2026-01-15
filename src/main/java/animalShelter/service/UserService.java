package animalShelter.service;

import animalShelter.entity.User;
import io.micrometer.observation.ObservationFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public List<User> getAllUsers() {
    }

    public ObservationFilter getUserById(Long id) {}
    public ObservationFilter getUserByEmail(String email) {}
    public User createUser(User user) {}
    public User updateUser(Long id, User user) {}
    public void deleteUser(Long id) {}

//    private final UserRepository userRepository;

}