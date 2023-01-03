package ru.graduationproject.restaurantvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.graduationproject.restaurantvoting.model.User;
import ru.graduationproject.restaurantvoting.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void delete (int id) {
        userRepository.delete(id);
    }
}
