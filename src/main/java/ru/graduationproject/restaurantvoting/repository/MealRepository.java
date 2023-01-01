package ru.graduationproject.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.graduationproject.restaurantvoting.model.Meal;

import java.util.List;

@Transactional(readOnly = true)
public interface MealRepository extends JpaRepository<Meal, Integer> {

    List<Meal> findByRestaurantId(int restaurantId);


    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id=:id")
    int delete(@Param("id") int id);
}
