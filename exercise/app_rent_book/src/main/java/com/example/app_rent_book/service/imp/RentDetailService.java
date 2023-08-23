package com.example.app_rent_book.service.imp;

import com.example.app_rent_book.model.RentDetail;
import com.example.app_rent_book.repository.IRentDetailRepository;
import com.example.app_rent_book.service.IRentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentDetailService implements IRentDetailService {

    @Autowired
    private IRentDetailRepository rentDetailRepository;

    @Override
    public List<RentDetail> findAll() {
        return rentDetailRepository.findAll();
    }

    @Override
    public Optional<RentDetail> findById(Integer id) {
        return rentDetailRepository.findById(id);
    }

    @Override
    public void save(RentDetail rentDetail) {
        rentDetailRepository.save(rentDetail);
    }

    @Override
    public void remove(Integer id) {
        rentDetailRepository.deleteById(id);
    }

    @Override
    public List<RentDetail> findAllByRentStatusContaining(int status) {
        return rentDetailRepository.findAllByRentStatusContaining(status);
    }
}
