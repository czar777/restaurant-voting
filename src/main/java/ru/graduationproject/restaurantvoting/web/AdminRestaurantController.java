package ru.graduationproject.restaurantvoting.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.graduationproject.restaurantvoting.model.Restaurant;
import ru.graduationproject.restaurantvoting.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping(value = AdminRestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantController {

    static final String REST_URL = "/admin/restaurants";

    private final RestaurantService restaurantService;

    @Autowired
    public AdminRestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return restaurantService.get(id);
    }

    @GetMapping()
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return restaurantService.create(restaurant);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable int id, @RequestBody Restaurant restaurant) {
        restaurantService.update(restaurant, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        restaurantService.delete(id);
    }

}
