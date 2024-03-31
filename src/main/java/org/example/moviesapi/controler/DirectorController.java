package org.example.moviesapi.controler;

import org.example.moviesapi.Facades.BookMarksFacade;
import org.example.moviesapi.Services.Service.DirectorService;

import org.example.moviesapi.model.Dto.UserBookmarkDto;
import org.example.moviesapi.model.entity.DirectorModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/directors")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @Autowired
    private BookMarksFacade bookMarksFacade;

    @GetMapping
    public ResponseEntity<List<DirectorModel>> findAll()
    {
        List<DirectorModel> response = directorService.listUsers();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<DirectorModel>> findById(@PathVariable Long id)
    {
        Optional<DirectorModel> response = directorService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/bookmark/{id}")
    public ResponseEntity<?> findFavoritesBookMark(@PathVariable Long id)
    {
        UserBookmarkDto response = bookMarksFacade.getFavorites(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DirectorModel> save(@RequestBody DirectorModel directorModel)
    {
        DirectorModel response = directorService.create(directorModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<DirectorModel> update(@RequestBody DirectorModel userModel)
    {
        DirectorModel response = directorService.update(userModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = directorService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
