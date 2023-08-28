package com.example.case_study_module_4.service.imp;
import com.example.case_study_module_4.model.product.Image;
import com.example.case_study_module_4.repository.IImageRepository;
import com.example.case_study_module_4.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements IImageService {

    @Autowired
    private IImageRepository imageRepository;

    @Override
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Integer id) {
        return imageRepository.findById(id);
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void remove(Integer id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Iterable<Image> findAllByVehicleContaining(int vehicleId) {
        return imageRepository.findAllByVehicleContaining(vehicleId);
    }
}
