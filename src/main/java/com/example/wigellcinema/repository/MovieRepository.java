package com.example.wigellcinema.repository;

import com.example.wigellcinema.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository <Movies, Integer> {

}
