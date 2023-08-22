package com.example.validate_info_music.repository;

import com.example.validate_info_music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
}
