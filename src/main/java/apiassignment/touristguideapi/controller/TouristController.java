package apiassignment.touristguideapi.controller;

import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.model.Season;
import apiassignment.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class TouristController {

private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }
  
    @GetMapping("/attractions/test")
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

    @GetMapping("/seasons/{name}")
    public String getAttractionBySeason(@PathVariable Season name, Model model) {
        List<TouristAttraction> attractionBySeason = touristService.getAttractionBySeason(name);
        model.addAttribute("attractionBySeason", attractionBySeason);
        return "attractionBySeason";
    }

    @PostMapping("/{name}/delete")
    public String removeAttraction(@PathVariable String name) {
        TouristAttraction deleteAttraction = touristService.removeAttraction(name);
        return "redirect:/attractions";
    }

    @GetMapping("/attractions")
    public String listAttactions(Model model) {
        List<TouristAttraction> farvel = touristService.getAllAttractions();
        model.addAttribute("attractions", farvel);
        return "attractionList";
    }


    @GetMapping("/{name}/tags")
    public String attractionTags(Model model, @PathVariable String name) {
        model.addAttribute("attractionsTags", null);
        return "tags";
    }

    @GetMapping("/add")
    public String addAttractions(Model model) {
        TouristAttraction addAttraction = new TouristAttraction();
        model.addAttribute("touristAttraction", addAttraction);
        model.addAttribute("seasonTypes", Season.values());
        return "addAttractions";
    }

    @PostMapping("/add")
    public String updateAttractions(@ModelAttribute TouristAttraction t1) {
        touristService.addTouristAttraction(t1);
        return "redirect:/save";
    }


    @GetMapping("/save")
    public String saveAtractions(Model model) {
        return "save";
    }

    @PostMapping("/attractions/update")
    public ResponseEntity<TouristAttraction> renameAttraction(@RequestBody TouristAttraction newTouristAttraction) {
        TouristAttraction newTouristAttractionList = touristService.renameAttraction(newTouristAttraction);
        return new ResponseEntity<>(newTouristAttractionList, HttpStatus.OK);
    }

    @GetMapping("/update")
    public String updateAttraction(Model model) {
        List<TouristAttraction> getAllAttractions = touristService.getAllAttractions();
        TouristAttraction updateAttraction = new TouristAttraction();
        model.addAttribute("seasonTypes", Season.values());
        model.addAttribute("getAllAttractions", getAllAttractions);
        model.addAttribute("updateAttraction", updateAttraction);
        return "updateAttraction";
    }

    @PostMapping("/update")
    public String processUpdate(@ModelAttribute("updateAttraction") TouristAttraction updateAttraction, Model model) {
        TouristAttraction updated = touristService.renameAttraction(updateAttraction);
        return "redirect:/save";

    }
}






