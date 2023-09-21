package com.example.channuoiheo.service.imp;

import com.example.channuoiheo.model.Pig;
import com.example.channuoiheo.repository.IPigRepository;
import com.example.channuoiheo.service.IPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PigService implements IPigService {

    @Autowired
    IPigRepository pigRepository;

    @Override
    public List<Pig> findAll() {
        return pigRepository.findAll();
    }

    @Override
    public Optional<Pig> findById(Integer id) {
        return pigRepository.findById(id);
    }

    @Override
    public void save(Pig pig) {
        pigRepository.save(pig);
    }

    @Override
    public void remove(Integer id) {
        pigRepository.deleteById(id);
    }


    @Override
    public Optional<Pig> getPigByCodeContains(String code) {
        return pigRepository.getPigByCodeContains(code);
    }

    @Override
    public Page<Pig> findAllBySearch(Pageable pageable, String search) {
        return pigRepository.findAllBySearch(pageable, "%" + search + "%");
    }
}
