package ru.umnikov.spring.spring_springboot.SpringBoot3_1_2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.umnikov.spring.spring_springboot.SpringBoot3_1_2.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
