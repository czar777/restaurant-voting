package ru.graduationproject.restaurantvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.graduationproject.restaurantvoting.model.Meal;
import ru.graduationproject.restaurantvoting.service.MealService;

import java.util.List;

@RestController
@RequestMapping(value = AdminMealController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminMealController {

    static final String REST_URL = "/restaurants/{restaurantId}/meals";

    private final MealService mealService;

    @Autowired
    public AdminMealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/{id}")
    public Meal get(@PathVariable int id, @PathVariable int restaurantId) {
        return mealService.get(id);
    }

    @GetMapping
    public List<Meal> getAll(@PathVariable int restaurantId) {
        return mealService.getAll(restaurantId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Meal create(@PathVariable int restaurantId, @RequestBody Meal meal) {
        return mealService.create(meal, restaurantId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable int restaurantId, @PathVariable int id, @RequestBody Meal meal) {
        mealService.update(meal, id, restaurantId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id, @PathVariable int restaurantId) {
        mealService.delete(id);
    }

}
