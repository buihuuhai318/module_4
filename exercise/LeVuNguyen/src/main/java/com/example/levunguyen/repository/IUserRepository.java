package com.example.levunguyen.repository;

import com.example.levunguyen.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser getAppUserByUsernameContaining(String username);
}
