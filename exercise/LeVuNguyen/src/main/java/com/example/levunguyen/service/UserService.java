package com.example.levunguyen.service;

import com.example.levunguyen.model.AppUser;
import com.example.levunguyen.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(AppUser user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }
}
