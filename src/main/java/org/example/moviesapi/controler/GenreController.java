package org.example.moviesapi.controler;

import org.example.moviesapi.Facades.BookMarksFacade;
import org.example.moviesapi.Services.Service.GenreService;

import org.example.moviesapi.model.Dto.UserBookmarkDto;
import org.example.moviesapi.model.entity.GenreModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @Autowired
    private BookMarksFacade bookMarksFacade;

    @GetMapping
    public ResponseEntity<List<GenreModel>> findAll()
    {
        List<GenreModel> response = genreService.listUsers();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<GenreModel>> findById(@PathVariable Long id)
    {
        Optional<GenreModel> response = genreService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/bookmark/{id}")
    public ResponseEntity<?> findFavoritesBookMark(@PathVariable Long id)
    {
        UserBookmarkDto response = bookMarksFacade.getFavorites(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<GenreModel> save(@RequestBody GenreModel genreModel)
    {
        GenreModel response = genreService.create(genreModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<GenreModel> update(@RequestBody GenreModel userModel)
    {
        GenreModel response = genreService.update(userModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = genreService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
