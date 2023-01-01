package ru.graduationproject.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.graduationproject.restaurantvoting.model.Meal;
import ru.graduationproject.restaurantvoting.repository.MealRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class MealService {

    private final MealRepository mealRepository;

    public Optional<Meal> get(int id) {
        return mealRepository.findById(id);
    }

    public List<Meal> getAll(int restaurantId) {
        return mealRepository.findByRestaurantId(restaurantId);
    }

    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Transactional
    public Meal create(Meal meal) {
        return mealRepository.save(meal);
    }

    @Transactional
    public Meal update(Meal meal) {
        return mealRepository.save(meal);
    }

    @Transactional
    public void delete(int id) {
        mealRepository.delete(id);
    }
}
