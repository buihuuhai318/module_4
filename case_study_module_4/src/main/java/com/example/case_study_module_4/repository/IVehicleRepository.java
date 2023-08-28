package com.example.case_study_module_4.repository;


import com.example.case_study_module_4.model.product.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
}
