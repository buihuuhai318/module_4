package com.example.channuoiheo.service.imp;

import com.example.channuoiheo.model.Pct;
import com.example.channuoiheo.repository.IPctRepository;
import com.example.channuoiheo.service.IPctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PctService implements IPctService {

    @Autowired
    private IPctRepository pctRepository;

    @Override
    public List<Pct> findAll() {
        return pctRepository.findAll();
    }

    @Override
    public Optional<Pct> findById(Integer id) {
        return pctRepository.findById(id);
    }

    @Override
    public void save(Pct pct) {
        pctRepository.save(pct);
    }

    @Override
    public void remove(Integer id) {
        pctRepository.deleteById(id);
    }

    @Override
    public Page<Pct> findAllBySearch(Pageable pageable) {
        return pctRepository.findAllBySearch(pageable);
    }
}
