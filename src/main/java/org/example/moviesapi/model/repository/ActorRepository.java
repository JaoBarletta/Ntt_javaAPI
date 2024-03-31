package org.example.moviesapi.model.repository;

import org.example.moviesapi.model.entity.ActorModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends JpaRepository<ActorModel, Long> {
    ActorModel findByName (String name);



    @Query("from UserModel u where u.name = :name") //JPQL
    ActorModel busquePorNome (String name);



}
