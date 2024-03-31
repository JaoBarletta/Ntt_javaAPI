package org.example.moviesapi.Services.ServicesImpl;

import org.example.moviesapi.Services.Service.ActorService;
import org.example.moviesapi.handlers.ParametroInvalidoException;
import org.example.moviesapi.handlers.RecursoNaoEncontradoExecption;

import org.example.moviesapi.model.entity.ActorModel;
import org.example.moviesapi.model.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository ActorRepository;

    @Override
    public List<ActorModel> listUsers() {
        return ActorRepository.findAll();
    }

    @Override
    public List<ActorModel> list() {
        return null;
    }

    @Override
    public Optional<ActorModel> findById(Long id) {
        return ActorRepository.findById(id);
    }

    @Override
    public ActorModel create(ActorModel actorModel) {
        return null;
    }


    @Override
    public ActorModel update(ActorModel actorModel) {

        if(actorModel.getId() == null || findById(actorModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return ActorRepository.save(actorModel);
    }

    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            ActorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoExecption("Id informado não encontrado!");
        }

    }
}
