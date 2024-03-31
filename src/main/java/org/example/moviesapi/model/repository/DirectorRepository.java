package org.example.moviesapi.model.repository;

import org.example.moviesapi.model.entity.ActorModel;
import org.example.moviesapi.model.entity.DirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<DirectorModel, Long> {
    DirectorModel findByName (String name);

    List<DirectorModel> list();

    Optional<DirectorModel> findById(Long id);

    DirectorModel create(DirectorModel directorModel);

    DirectorModel update(DirectorModel directorModel);

    @Query("from DirectorModel u where u.name = :name") //JPQL
    DirectorModel busquePorNome (String name);





}
