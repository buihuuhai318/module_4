package com.example.app_rent_book.repository;

import com.example.app_rent_book.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogRepository extends JpaRepository<Log, Integer> {
}
