package org.example.moviesapi.Services.ServicesImpl;

import org.example.moviesapi.Services.Service.DirectorService;
import org.example.moviesapi.handlers.ParametroInvalidoException;
import org.example.moviesapi.handlers.RecursoNaoEncontradoExecption;
import org.example.moviesapi.model.entity.DirectorModel;
import org.example.moviesapi.model.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public List<DirectorModel> listUsers() {
        return directorRepository.findAll();
    }

    @Override
    public List<DirectorModel> list() {
        return null;
    }

    @Override
    public Optional<DirectorModel> findById(Long id) {
        return directorRepository.findById(id);
    }

    @Override
    public DirectorModel create(DirectorModel directorModel) {
        return null;
    }


    @Override
    public DirectorModel update(DirectorModel directorModel) {

        if( findById(directorModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return directorRepository.save(directorModel);
    }

    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            directorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoExecption("Id informado não encontrado!");
        }

    }
}
