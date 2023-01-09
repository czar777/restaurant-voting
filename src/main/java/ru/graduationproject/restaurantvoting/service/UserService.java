package ru.graduationproject.restaurantvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.graduationproject.restaurantvoting.model.Restaurant;
import ru.graduationproject.restaurantvoting.model.User;
import ru.graduationproject.restaurantvoting.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    private final static LocalTime TIME_CHANGE_VOTE = LocalTime.of(11, 00, 00);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(int id) {
        return userRepository.findById(id).get();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void update(User user, int id) {
        user.setId(id);
        userRepository.save(user);
    }

    @Transactional
    public void delete (int id) {
        userRepository.delete(id);
    }

    @Transactional
    public void vote(Restaurant restaurant, int id) {
        User user = get(id);
        LocalDateTime ldt = LocalDateTime.now();

        if (ldt.toLocalTime().isAfter(TIME_CHANGE_VOTE)) {
            System.out.println("Голосовать после 11:00 нельзя!");
            throw new RuntimeException("Голосовать после 11:00 нельзя!");
        }

        user.setVoiceRestaurant(restaurant);
        userRepository.save(user);
    }

}
