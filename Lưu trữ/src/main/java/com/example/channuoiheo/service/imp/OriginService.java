package com.example.channuoiheo.service.imp;

import com.example.channuoiheo.model.Origin;
import com.example.channuoiheo.repository.IOriginRepository;
import com.example.channuoiheo.service.IOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OriginService implements IOriginService {

    @Autowired
    IOriginRepository originRepository;

    @Override
    public List<Origin> findAll() {
        return originRepository.findAll();
    }

    @Override
    public Optional<Origin> findById(Integer id) {
        return originRepository.findById(id);
    }

    @Override
    public void save(Origin origin) {
        originRepository.save(origin);
    }

    @Override
    public void remove(Integer id) {
        originRepository.deleteById(id);
    }
}
