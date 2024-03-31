package org.example.moviesapi.model.repository;

import org.example.moviesapi.model.entity.ActorModel;
import org.example.moviesapi.model.entity.FranchiseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FranchiseRepository extends JpaRepository<FranchiseModel, Long> {
    FranchiseModel findByName (String name);

    @Query("fromFranchiseModel u where u.name = :name") //JPQL
    FranchiseModel busquePorNome (String name);


}

