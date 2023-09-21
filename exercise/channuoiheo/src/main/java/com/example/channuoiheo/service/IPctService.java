package com.example.channuoiheo.service;

import com.example.channuoiheo.model.Pct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPctService extends IGenerateService<Pct> {
    Page<Pct> findAllBySearch(Pageable pageable);
}
