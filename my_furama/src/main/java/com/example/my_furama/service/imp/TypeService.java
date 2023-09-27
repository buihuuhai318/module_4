package com.example.my_furama.service.imp;

import com.example.my_furama.model.TypeCustomer;
import com.example.my_furama.repository.ITypeRepository;
import com.example.my_furama.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private ITypeRepository typeRepository;

    @Override
    public List<TypeCustomer> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<TypeCustomer> findById(Integer id) {
        return typeRepository.findById(id);
    }

    @Override
    public void save(TypeCustomer pct) {
        typeRepository.save(pct);
    }

    @Override
    public void remove(Integer id) {
        typeRepository.deleteById(id);
    }
}
