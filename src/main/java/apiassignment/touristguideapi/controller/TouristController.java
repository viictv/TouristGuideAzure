package apiassignment.touristguideapi.controller;

import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
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

    @GetMapping("/attractions/{name}")
    public String getAttractionByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
        if (attraction != null) {
            model.addAttribute("attraction", attraction);
            return "attractionbyname";
        }
        return "error";
    }

    @PostMapping("/attractions/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction t1) {
        TouristAttraction addAttraction = touristService.addTouristAttraction(t1);
        return new ResponseEntity<>(addAttraction, HttpStatus.CREATED);
        }

    @PostMapping("/attractions/update")
    public ResponseEntity<TouristAttraction> renameAttraction(@RequestBody TouristAttraction newTouristAttraction) {
        TouristAttraction newTouristAttractionList = touristService.renameAttraction(newTouristAttraction);
        return new ResponseEntity<>(newTouristAttractionList, HttpStatus.OK);
    }

    @PostMapping("/attractions/delete/{name}")
    public ResponseEntity<TouristAttraction> removeAttraction(@PathVariable String name) {
        TouristAttraction test = touristService.removeAttraction(name);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @GetMapping("/attractions/season/{season}")
    public ResponseEntity<List<TouristAttraction>> getAttractionBySeason(@PathVariable String season) {
        ArrayList<TouristAttraction> t1 = touristService.getAttractionBySeason(season);
        return new ResponseEntity<>(t1, HttpStatus.OK);
    }

    @GetMapping("/attractions/rediger")
    public String redigerSite (Model model) {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        model.addAttribute("attractions", attractions);
        return "rediger";
    }


    @GetMapping("/attractions/alle")
    public String listAttactions(Model model) {
        List<TouristAttraction> farvel = touristService.getAllAttractions();
        model.addAttribute("attractions", farvel);
        return "allAttractions";
    }

    @GetMapping("/attractions/seasons/sommer")
    public String listAttractionsBySeasonSommer(Model model) {
        List<TouristAttraction> t1 = touristService.getAttractionBySeason("Sommer");
        model.addAttribute("attractionsBySeason", t1);
        return "sommerAttractions";
    }

    @GetMapping("/attractions/seasons/vinter")
    public String listAttractionsBySeasonVinter(Model model) {
        List<TouristAttraction> t1 = touristService.getAttractionBySeason("Vinter");
        model.addAttribute("attractionsBySeason", t1);
        return "vinterAttractions";
    }

    @GetMapping("/attractions/seasons/helår")
    public String listAttractionsBySeasonHelår(Model model) {
        List<TouristAttraction> t1 = touristService.getAttractionBySeason("Helår");
        model.addAttribute("attractionsBySeason", t1);
        return "helÅr";
    }

    }



