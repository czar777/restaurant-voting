package ru.graduationproject.restaurantvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.graduationproject.restaurantvoting.model.Meal;
import ru.graduationproject.restaurantvoting.repository.MealRepository;
import ru.graduationproject.restaurantvoting.repository.RestaurantRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MealService {

    private final MealRepository mealRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public MealService(MealRepository mealRepository, RestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Meal get(int id) {
        return mealRepository.findById(id).get();
    }

    public List<Meal> getAll(int restaurantId) {
        return mealRepository.findByRestaurantId(restaurantId);
    }

    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Transactional
    public Meal create(Meal meal, int restaurantId) {
        meal.setRestaurant(restaurantRepository.findById(restaurantId).get());
        return mealRepository.save(meal);
    }

    @Transactional
    public void update(Meal meal, int id, int restaurantId) {
        if (meal.getId() != id) {

        }
        meal.setRestaurant(restaurantRepository.findById(restaurantId).get());
        mealRepository.save(meal);
    }

    @Transactional
    public void delete(int id) {
        mealRepository.delete(id);
    }
}
