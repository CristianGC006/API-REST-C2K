package com.C2KProyect.Api_Rest_C2K.repositories;


import com.C2KProyect.Api_Rest_C2K.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
