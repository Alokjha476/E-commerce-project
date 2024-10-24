package com.user.service.repository;

import com.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*// In JPQL use Alies
    @Query("SELECT u FROM User u WHERE u.username = :username")
    List<User> findByUserName(@Param("username") String username);*/

    // In SQL
    @Query(value = "select * from users where username = :username", nativeQuery = true)
    List<User> findByUserName(@Param("username") String username);


}
