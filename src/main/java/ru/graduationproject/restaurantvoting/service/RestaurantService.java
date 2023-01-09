package ru.graduationproject.restaurantvoting.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.graduationproject.restaurantvoting.model.Restaurant;
import ru.graduationproject.restaurantvoting.model.User;
import ru.graduationproject.restaurantvoting.repository.RestaurantRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant get(int id) {
        return restaurantRepository.findById(id).get();
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Transactional
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public void update(Restaurant restaurant, int id) {
        restaurant.setId(id);
        restaurantRepository.save(restaurant);
    }

    @Transactional
    public void delete(int id) {
        Restaurant restaurant = get(id);
        for (User user : restaurant.getVote()) {
            user.setVoiceRestaurant(null);
        }
        restaurant.setVote(null);
        restaurantRepository.delete(id);
    }
}

