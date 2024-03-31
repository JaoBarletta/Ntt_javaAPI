package org.example.moviesapi.Services.ServicesImpl;

import org.example.moviesapi.Services.Service.MovieService;
import org.example.moviesapi.handlers.RecursoNaoEncontradoExecption;
import org.example.moviesapi.model.entity.MovieModel;
import org.example.moviesapi.model.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {
    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<MovieModel> listUsers() {
        return moviesRepository.findAll();
    }

    @Override
    public List<MovieModel> list() {
        return null;
    }

    @Override
    public Optional<MovieModel> findById(Long id) {
        return moviesRepository.findById(Math.toIntExact(id));
    }

    @Override
    public MovieModel create(MovieModel franchiseModel) {
        return null;
    }

    @Override
    public MovieModel update(MovieModel franchiseModel) {
        return null;
    }

    @Override
    public List<MovieModel> getUser(Long id) {
        return null;
    }


    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            moviesRepository.deleteById(Math.toIntExact(id));
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoExecption("Id informado não encontrado!");
        }

    }
}
