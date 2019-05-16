package com.example.psp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.psp.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

}