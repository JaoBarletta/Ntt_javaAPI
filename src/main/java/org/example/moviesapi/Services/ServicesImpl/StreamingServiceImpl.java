package org.example.moviesapi.Services.ServicesImpl;

import org.example.moviesapi.Services.Service.StreamingService;
import org.example.moviesapi.handlers.RecursoNaoEncontradoExecption;
import org.example.moviesapi.model.entity.StreamingModel;
import org.example.moviesapi.model.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StreamingServiceImpl implements StreamingService {
    @Autowired
    private StreamingRepository streamingRepository;

    @Override
    public List<StreamingModel> listUsers() {
        return streamingRepository.findAll();
    }

    @Override
    public List<StreamingModel> list() {
        return null;
    }

    @Override
    public Optional<StreamingModel> findById(Long id) {
        return streamingRepository.findById(id);
    }

    @Override
    public StreamingModel create(StreamingModel streamingModel) {
        return null;
    }

    @Override
    public StreamingModel update(StreamingModel streamingModel) {
        return null;
    }

    @Override
    public List<StreamingModel> getUser(Long id) {
        return null;
    }


    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            streamingRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoExecption("Id informado não encontrado!");
        }

    }
}
