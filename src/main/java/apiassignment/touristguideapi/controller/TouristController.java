package apiassignment.touristguideapi.controller;

import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {

private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/test")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
    List<TouristAttraction> t1 = touristService.getAllAttractions();
    return new ResponseEntity<>(t1, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction t1 = touristService.getAttractionByName(name);
        return new ResponseEntity<>(t1,HttpStatus.OK);
    }

}
