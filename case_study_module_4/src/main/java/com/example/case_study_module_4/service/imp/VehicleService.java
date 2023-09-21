package com.example.case_study_module_4.service.imp;
import com.example.case_study_module_4.model.product.Vehicle;
import com.example.case_study_module_4.repository.IVehicleRepository;
import com.example.case_study_module_4.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> findById(Integer id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void remove(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
