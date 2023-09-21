package com.example.channuoiheo.repository;

import com.example.channuoiheo.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPigRepository extends JpaRepository<Pig, Integer> {
    Optional<Pig> getPigByCodeContains(String code);

    @Query(value = "select p.*, o.name " +
            "from pig p " +
            "join origin o on p.origin_id = o.id " +
            "where (payment_status like :search " +
            "or code like :search " +
            "or o.name like :search)" +
            "and delete_status = 0", nativeQuery = true)
    Page<Pig> findAllBySearch(Pageable pageable, @Param("search") String search);
}
