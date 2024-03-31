package org.example.moviesapi.model.repository;

import org.example.moviesapi.model.entity.ActorModel;
import org.example.moviesapi.model.entity.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<MovieModel,Integer> {
    MovieModel findByName (String name);



    @Query("from MovieModel u where u.name = :name") //JPQL
    MovieModel busquePorNome (String name);



    @Query("SELECT u FROM MovieModel u JOIN FETCH u.roles where u.username = :username")
    MovieModel findByUsernameFetchRoles(@Param("username") String username);




}
