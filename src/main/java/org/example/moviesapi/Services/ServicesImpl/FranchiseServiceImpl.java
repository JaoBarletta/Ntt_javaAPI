package org.example.moviesapi.Services.ServicesImpl;

import org.example.moviesapi.Services.Service.FranchiseService;
import org.example.moviesapi.handlers.RecursoNaoEncontradoExecption;
import org.example.moviesapi.model.entity.FranchiseModel;
import org.example.moviesapi.model.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FranchiseServiceImpl implements FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Override
    public List<FranchiseModel> listUsers() {
        return franchiseRepository.findAll();
    }

    @Override
    public List<FranchiseModel> list() {
        return null;
    }

    @Override
    public Optional<FranchiseModel> findById(Long id) {
        return franchiseRepository.findById(id);
    }

    @Override
    public FranchiseModel create(FranchiseModel franchiseModel) {
        return null;
    }

    @Override
    public FranchiseModel update(FranchiseModel franchiseModel) {
        return null;
    }


    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            franchiseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoExecption("Id informado não encontrado!");
        }

    }
}
