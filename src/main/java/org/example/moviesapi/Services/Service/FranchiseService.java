package org.example.moviesapi.Services.Service;

import org.example.moviesapi.model.entity.FranchiseModel;

import java.util.List;
import java.util.Optional;

public interface FranchiseService {

    List<FranchiseModel> listUsers();

    List<FranchiseModel> list();

    Optional<FranchiseModel> findById(Long id);

    FranchiseModel create(FranchiseModel franchiseModel);

    FranchiseModel update(FranchiseModel franchiseModel);

    boolean delete(Long id);
}
