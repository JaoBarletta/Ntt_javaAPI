package org.example.moviesapi.Services.Service;

import org.example.moviesapi.model.entity.StreamingModel;

import java.util.List;
import java.util.Optional;

public interface StreamingService {

    List<StreamingModel> listUsers();

    List<StreamingModel> list();

    Optional<StreamingModel> findById(Long id);

    StreamingModel create(StreamingModel streamingModel);

    StreamingModel update(StreamingModel streamingModel);

    List<StreamingModel> getUser(Long id);

    boolean delete(Long id);
}
