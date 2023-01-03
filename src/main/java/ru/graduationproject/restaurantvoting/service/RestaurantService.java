package ru.graduationproject.restaurantvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.graduationproject.restaurantvoting.model.Restaurant;
import ru.graduationproject.restaurantvoting.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Optional<Restaurant> get(int id) {
        return restaurantRepository.findById(id);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Transactional
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public void update(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Transactional
    public void delete(int id) {
        restaurantRepository.delete(id);
    }
}

