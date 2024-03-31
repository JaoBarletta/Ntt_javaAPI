package org.example.moviesapi.controler;

import org.example.moviesapi.Facades.BookMarksFacade;
import org.example.moviesapi.Services.Service.StreamingService;

import org.example.moviesapi.model.Dto.UserBookmarkDto;
import org.example.moviesapi.model.entity.StreamingModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/streamings")
public class StreamingController {
    @Autowired
    private StreamingService streamingService;

    @Autowired
    private BookMarksFacade bookMarksFacade;

    @GetMapping
    public ResponseEntity<List<StreamingModel>> findAll()
    {
        List<StreamingModel> response = streamingService.listUsers();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<StreamingModel>> findById(@PathVariable Long id)
    {
        Optional<StreamingModel> response = streamingService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/bookmark/{id}")
    public ResponseEntity<?> findFavoritesBookMark(@PathVariable Long id)
    {
        UserBookmarkDto response = bookMarksFacade.getFavorites(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<StreamingModel> save(@RequestBody StreamingModel streamingModel)
    {
        StreamingModel response = streamingService.create(streamingModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<StreamingModel> update(@RequestBody StreamingModel streamingModel)
    {
        StreamingModel response = streamingService.update(streamingModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = streamingService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
