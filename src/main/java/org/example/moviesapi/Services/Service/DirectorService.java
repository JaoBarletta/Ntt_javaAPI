package org.example.moviesapi.Services.Service;

import org.example.moviesapi.model.entity.DirectorModel;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    List<DirectorModel> listUsers();

    List<DirectorModel> list();

    Optional<DirectorModel> findById(Long id);

    DirectorModel create(DirectorModel directorModel);

    DirectorModel update(DirectorModel directorModel);

    boolean delete(Long id);
}
