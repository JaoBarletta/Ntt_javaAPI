package org.example.moviesapi.Services.Service;

import org.example.moviesapi.model.entity.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserModel> listUsers();

    Optional<UserModel> findById(Long id);

    UserModel create(UserModel userModel);

    UserModel update(UserModel userModel);

    boolean delete(Long id);
}
