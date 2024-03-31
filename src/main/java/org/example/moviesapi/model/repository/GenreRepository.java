package org.example.moviesapi.model.repository;

import org.example.moviesapi.model.entity.ActorModel;
import org.example.moviesapi.model.entity.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Long> {
    GenreModel findByName (String name);



    @Query("from GenreModel u where u.name = :name") //JPQL
    GenreModel busquePorNome (String name);


    @Query("SELECT u FROM GenreModel u JOIN FETCH u.roles where u.username = :username")
    GenreModel findByUsernameFetchRoles(@Param("username") String username);


}
