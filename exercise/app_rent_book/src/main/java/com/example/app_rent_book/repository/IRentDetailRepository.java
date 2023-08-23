package com.example.app_rent_book.repository;

import com.example.app_rent_book.model.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRentDetailRepository extends JpaRepository<RentDetail, Integer> {

    @Query(value = "select * from rent_info where rent_status = :status", nativeQuery = true)
    public List<RentDetail> findAllByRentStatusContaining(@Param("status") int status);
}
