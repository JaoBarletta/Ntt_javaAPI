package org.example.moviesapi.Services.Service;

import org.example.moviesapi.model.entity.MovieModel;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieModel> listUsers();

    List<MovieModel> list();

    Optional<MovieModel> findById(Long id);

    MovieModel create(MovieModel movieModel);

    MovieModel update(MovieModel movieModel);

    List<MovieModel> getUser(Long id);

    boolean delete(Long id);
}
