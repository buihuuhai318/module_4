package com.example.case_study_module_4.repository;

import com.example.case_study_module_4.model.product.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Integer> {
    Iterable<Image> findAllByVehicleContaining(int vehicleId);
}
