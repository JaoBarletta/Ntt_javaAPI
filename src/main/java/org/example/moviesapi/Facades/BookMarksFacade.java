package org.example.moviesapi.Facades;

import org.example.moviesapi.model.Dto.UserBookmarkDto;
import org.example.moviesapi.model.Dto.UserDto;

public interface BookMarksFacade {

    UserBookmarkDto getFavorites(Long id);
}
