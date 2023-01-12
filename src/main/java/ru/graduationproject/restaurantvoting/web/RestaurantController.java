package ru.graduationproject.restaurantvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.graduationproject.restaurantvoting.model.Meal;
import ru.graduationproject.restaurantvoting.model.Restaurant;
import ru.graduationproject.restaurantvoting.service.MealService;
import ru.graduationproject.restaurantvoting.service.RestaurantService;
import ru.graduationproject.restaurantvoting.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {

    static final String REST_URL = "/restaurants";

    private final UserService userService;
    private final MealService mealService;
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(UserService userService, MealService mealService, RestaurantService restaurantService) {
        this.userService = userService;
        this.mealService = mealService;
        this.restaurantService = restaurantService;
    }

    @PutMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void vote(@RequestBody Restaurant restaurant) {
        userService.vote(restaurant, 1);
    }

    @GetMapping("/meals/{id}")
    public Meal getMeal(@PathVariable int id, @PathVariable int restaurantId) {
        return mealService.get(id);
    }

    @GetMapping("/meals")
    public List<Meal> getAllMeal(@PathVariable int restaurantId) {
        return mealService.getAll(restaurantId);
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable int id) {
        return restaurantService.get(id);
    }

    @GetMapping()
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAll();
    }
}
