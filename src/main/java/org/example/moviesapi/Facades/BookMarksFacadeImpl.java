package org.example.moviesapi.Facades;

import org.example.moviesapi.Services.Service.MovieService;
import org.example.moviesapi.Services.Service.UserService;
import org.example.moviesapi.model.Dto.UserBookmarkDto;
import org.example.moviesapi.model.Dto.UserDto;
import org.example.moviesapi.model.entity.DirectorModel;
import org.example.moviesapi.model.entity.MovieModel;
import org.example.moviesapi.model.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookMarksFacadeImpl implements BookMarksFacade {

    @Autowired
    MovieService movieService;

    @Autowired
    UserService userService;

    @Override
    public UserBookmarkDto getFavorites(Long id) {

        UserBookmarkDto userBookmarkDto = new UserBookmarkDto();

        Optional<UserModel> userModel = userService.findById(id);

        List<MovieModel> movieFavorites = movieService.getUser(userModel.get().getId());

        userBookmarkDto.setUserDto(new UserDto(userModel.get()));
        userBookmarkDto.setMovies(movieFavorites);
        userBookmarkDto.setDirectors(new ArrayList<DirectorModel>());

        return userBookmarkDto;
    }
}
