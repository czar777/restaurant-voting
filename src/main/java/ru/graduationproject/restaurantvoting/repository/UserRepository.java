package ru.graduationproject.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.graduationproject.restaurantvoting.model.User;


@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Override
//    Optional<User> findById(Integer integer);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);
}
