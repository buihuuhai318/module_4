package com.example.channuoiheo.service;

import com.example.channuoiheo.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPigService extends IGenerateService<Pig> {
    Optional<Pig> getPigByCodeContains(String code);

    Page<Pig> findAllBySearch(Pageable pageable, String search);
}
