package org.example.moviesapi.Services.Service;

import org.example.moviesapi.model.entity.GenreModel;
import org.example.moviesapi.model.entity.MovieModel;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<GenreModel> listUsers();

    List<GenreModel> list();

    Optional<GenreModel> findById(Long id);

    GenreModel create(GenreModel genreModel);

    GenreModel update(GenreModel genreModel);

    List<GenreModel> getUser(Long id);

    boolean delete(Long id);
}