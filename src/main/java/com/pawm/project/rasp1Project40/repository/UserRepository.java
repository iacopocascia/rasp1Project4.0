package com.pawm.project.rasp1Project40.repository;


import com.pawm.project.rasp1Project40.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
