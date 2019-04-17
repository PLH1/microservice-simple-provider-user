package com.itmuch.cloud.microservicesimpleprovideruser.dao;


import com.itmuch.cloud.microservicesimpleprovideruser.daomain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
