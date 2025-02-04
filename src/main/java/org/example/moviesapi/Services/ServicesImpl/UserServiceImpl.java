package org.example.moviesapi.Services.ServicesImpl;

import org.example.moviesapi.Services.Service.UserService;
import org.example.moviesapi.handlers.ParametroInvalidoException;
import org.example.moviesapi.handlers.RecursoNaoEncontradoExecption;
import org.example.moviesapi.model.entity.UserModel;
import org.example.moviesapi.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public UserModel create(UserModel userModel) {

        userModel.setId(null);

        UserModel existUser = userRepository.findByUsername(userModel.getUsername());

        if (existUser != null)
        {
            throw new ParametroInvalidoException("Usuario ja existe");
        }


        return userRepository.save(userModel);
    }

    @Override
    public UserModel update(UserModel userModel) {

        if(userModel.getId() == null || findById(userModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return userRepository.save(userModel);
    }

    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoExecption("Id informado não encontrado!");
        }

    }
}
