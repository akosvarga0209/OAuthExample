package com.oauth.oauth.reporitories;

import com.oauth.oauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
