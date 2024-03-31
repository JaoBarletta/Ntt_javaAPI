package org.example.moviesapi.Services.Service;

import org.example.moviesapi.model.entity.ActorModel;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<ActorModel> listUsers();

    List<ActorModel> list();

    Optional<ActorModel> findById(Long id);

    ActorModel create(ActorModel actorModel);

    ActorModel update(ActorModel actorModel);

    boolean delete(Long id);
}
