package org.example.moviesapi.controler;



import org.example.moviesapi.model.entity.MovieModel;
import org.example.moviesapi.model.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/movies")
public class MovieController {
    private MoviesRepository moviesRepository;

@Autowired
public MovieController(MoviesRepository moviesRepository){
    this.moviesRepository = moviesRepository;


}
    @GetMapping
    public MovieModel getMovieById(){
        return (MovieModel) moviesRepository.findById(1).get();
    }
}

