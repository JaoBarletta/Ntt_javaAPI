package org.example.moviesapi.model.repository;

import org.example.moviesapi.model.entity.StudioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudioRepository extends JpaRepository<StudioModel, Long> {

    StudioModel findByName(String name);

    StudioModel findByCountry(String country);

    StudioModel findByNameOrCountry(String name, String country);

    //JPQL fazer querys personalizadas
    @Query("from StudioModel sm where sm.name = :name")
    StudioModel buscaPorNome(String name);
}