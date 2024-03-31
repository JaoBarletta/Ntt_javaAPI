package org.example.moviesapi.controler;

import org.example.moviesapi.Facades.BookMarksFacade;
import org.example.moviesapi.Services.Service.ActorService;

import org.example.moviesapi.model.Dto.UserBookmarkDto;
import org.example.moviesapi.model.entity.ActorModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;


    @Autowired
    private BookMarksFacade bookMarksFacade;

    @GetMapping
    public ResponseEntity<List<ActorModel>> findAll()
    {
        List<ActorModel> response = actorService.listUsers();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ActorModel>> findById(@PathVariable Long id)
    {
        Optional<ActorModel> response = actorService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/bookmark/{id}")
    public ResponseEntity<?> findFavoritesBookMark(@PathVariable Long id)
    {
        UserBookmarkDto response = bookMarksFacade.getFavorites(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ActorModel> save(@RequestBody ActorModel actorModel)
    {
        ActorModel response = actorService.create(actorModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ActorModel> update(@RequestBody ActorModel actorModel)
    {
        ActorModel response = actorService.update(actorModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = actorService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
