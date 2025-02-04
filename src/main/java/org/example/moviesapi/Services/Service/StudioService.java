package org.example.moviesapi.Services.Service;

import org.example.moviesapi.model.entity.StudioModel;

import java.util.List;
import java.util.Optional;

public interface StudioService {

    List<StudioModel> listUsers();

    List<StudioModel> list();

    Optional<StudioModel> findById(Long id);

    Optional<StudioModel> findByName(String name);

    StudioModel create(StudioModel studioModel);

    StudioModel update(StudioModel studioModel);

    List<StudioModel> getUser(Long id);

    boolean delete(Long id);
}
