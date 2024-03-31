package org.example.moviesapi.Services.ServicesImpl;

import org.example.moviesapi.Services.Service.StudioService;
import org.example.moviesapi.handlers.RecursoNaoEncontradoExecption;
import org.example.moviesapi.model.entity.StudioModel;
import org.example.moviesapi.model.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudioServiceImpl implements StudioService {
    @Autowired
    private StudioRepository studioRepository;

    @Override
    public List<StudioModel> listUsers() {
        return studioRepository.findAll();
    }

    @Override
    public List<StudioModel> list() {
        return null;
    }

    @Override
    public Optional<StudioModel> findById(Long id) {
        return studioRepository.findById(id);
    }

    @Override
    public Optional<StudioModel> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public StudioModel create(StudioModel studioModel) {
        return null;
    }

    @Override
    public StudioModel update(StudioModel studioModel) {
        return null;
    }


    @Override
    public List<StudioModel> getUser(Long id) {
        return null;
    }


    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            studioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoExecption("Id informado não encontrado!");
        }

    }
}

