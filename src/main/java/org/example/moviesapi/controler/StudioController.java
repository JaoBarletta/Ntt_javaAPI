package org.example.moviesapi.controler;

import org.example.moviesapi.Facades.BookMarksFacade;
import org.example.moviesapi.Services.Service.StudioService;

import org.example.moviesapi.model.Dto.UserBookmarkDto;
import org.example.moviesapi.model.entity.StudioModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class StudioController {
    @Autowired
    private StudioService studioService;

    @Autowired
    private BookMarksFacade bookMarksFacade;

    @GetMapping
    public ResponseEntity<List<StudioModel>> findAll()
    {
        List<StudioModel> response = studioService.listUsers();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<StudioModel>> findById(@PathVariable Long id)
    {
        Optional<StudioModel> response = studioService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/bookmark/{id}")
    public ResponseEntity<?> findFavoritesBookMark(@PathVariable Long id)
    {
        UserBookmarkDto response = bookMarksFacade.getFavorites(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<StudioModel> save(@RequestBody StudioModel studioModel)
    {
        StudioModel response = studioService.create(studioModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<StudioModel> update(@RequestBody StudioModel studioModel)
    {
        StudioModel response = studioService.update(studioModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = studioService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
