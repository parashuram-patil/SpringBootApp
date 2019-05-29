package com.example.psp.repository.citi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.psp.entity.citi.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
	
	@Query("SELECT city FROM CityEntity city WHERE LOWER(city.name) = LOWER(:name)") 
    List<CityEntity> findByName(@Param("name") String cityName);

}