package com.example.case_study_module_4.service;

import com.example.case_study_module_4.model.product.Image;

public interface IImageService extends IGenerateService<Image> {
    Iterable<Image> findAllByVehicleContaining(int vehicleId);
}
