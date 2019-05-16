package com.example.psp.repository.citi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.psp.entity.citi.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

}