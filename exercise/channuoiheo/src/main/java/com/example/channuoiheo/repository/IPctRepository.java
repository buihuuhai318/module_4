package com.example.channuoiheo.repository;

import com.example.channuoiheo.model.Pct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPctRepository extends JpaRepository<Pct, Integer> {

    @Query(value = "select * from pct ", nativeQuery = true)
    Page<Pct> findAllBySearch(Pageable pageable);
}
