package org.example.moviesapi.model.Dto;

import org.example.moviesapi.model.entity.DirectorModel;
import org.example.moviesapi.model.entity.MovieModel;

import java.util.List;

public class UserBookmarkDto {

    private UserDto userDto;
    private List<MovieModel> movies;

    private List<DirectorModel> directors;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }

    public List<DirectorModel> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorModel> directors) {
        this.directors = directors;
    }
}
