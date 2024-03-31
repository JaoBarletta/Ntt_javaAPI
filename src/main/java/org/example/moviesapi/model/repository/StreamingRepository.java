package org.example.moviesapi.model.repository;

import org.example.moviesapi.model.entity.ActorModel;
import org.example.moviesapi.model.entity.StreamingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StreamingRepository extends JpaRepository<StreamingModel, Long> {

    StreamingModel findByName (String name);



    @Query("from UserModel u where u.name = :name") //JPQL
    StreamingModel busquePorNome (String name);



    @Query("SELECT u FROM UserModel u JOIN FETCH u.roles where u.username = :username")
    StreamingModel findByUsernameFetchRoles(@Param("username") String username);


}
