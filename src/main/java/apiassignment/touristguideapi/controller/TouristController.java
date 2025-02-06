package apiassignment.touristguideapi.controller;

import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {

private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/attractions")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
    List<TouristAttraction> t1 = touristService.getAllAttractions();
    return new ResponseEntity<>(t1, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction t1 = touristService.getAttractionByName(name);
        return new ResponseEntity<>(t1,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction t1) {
        TouristAttraction addAttraction = touristService.addTouristAttraction(t1);
        return new ResponseEntity<>(addAttraction, HttpStatus.CREATED);
        }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> renameAttraction(@RequestBody String name, String replacementname) {
        TouristAttraction test = touristService.renameAttraction(name, replacementname);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> removeAttraction(@PathVariable String name) {
        TouristAttraction test = touristService.removeAttraction(name);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }


    }



