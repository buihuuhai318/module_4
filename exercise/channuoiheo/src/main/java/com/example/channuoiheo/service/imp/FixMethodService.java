package com.example.channuoiheo.service.imp;

import com.example.channuoiheo.model.FixMethod;
import com.example.channuoiheo.repository.IFixMethodRepository;
import com.example.channuoiheo.service.IFixMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixMethodService implements IFixMethodService {

    @Autowired
    private IFixMethodRepository fixMethodRepository;

    @Override
    public List<FixMethod> findAll() {
        return fixMethodRepository.findAll();
    }

    @Override
    public Optional<FixMethod> findById(Integer id) {
        return fixMethodRepository.findById(id);
    }

    @Override
    public void save(FixMethod fixMethod) {
        fixMethodRepository.save(fixMethod);
    }

    @Override
    public void remove(Integer id) {
        fixMethodRepository.deleteById(id);
    }
}
