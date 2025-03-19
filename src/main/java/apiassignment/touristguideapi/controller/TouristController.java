package apiassignment.touristguideapi.controller;

import apiassignment.touristguideapi.model.*;
import apiassignment.touristguideapi.service.TouristService;
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
    public String listAttactions(Model model) {
        List<TouristAttraction> farvel = touristService.getAllAttractions();
        model.addAttribute("attractions", farvel);
        return "attractionList";
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

    //Sofies cook
    @GetMapping("/attractions/{name}/tags")
    public String getTagsByAttractionName(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
        model.addAttribute("tags", attraction.getTagsList());
        return "tags";  // Den view, hvor tags vises
    }

    @GetMapping("/attractions/add")
    public String addAttractions(Model model) {
        TouristAttraction addAttraction = new TouristAttraction();
        List<CityModel> getAllCities = touristService.getAllCities();
        List<SeasonModel> getAllSeasons = touristService.getAllSeasons();
        List<TagsModel> getAllTags = touristService.getAllTags();
        model.addAttribute("touristAttraction", addAttraction);
        model.addAttribute("seasonTypes", getAllSeasons);
        model.addAttribute("getAllCities", getAllCities);
        model.addAttribute("getAllTags", getAllTags);
        return "addAttractions";
    }

    @PostMapping("/attractions/save")
    public String updateAttractions(@RequestParam(name = "tagsList", required = false) List<String> tagsList, @ModelAttribute TouristAttraction t1) {
        /*List<TagsModel> tags = new ArrayList<>();
        for(String tagName : tagsList) {
            TagsModel tag = Tags.valueOf(tagName);
            tags.add(tag);
        }
        t1.setTagsList(tags);*/
        touristService.addTouristAttraction(t1);
        return "redirect:/updatedlist";
    }

    @GetMapping("/attractions/edit")
    public String updateAttraction(Model model) {
        List<CityModel> getAllCities = touristService.getAllCities();
        List<SeasonModel> getAllSeasons = touristService.getAllSeasons();
        List<TagsModel> getAllTags = touristService.getAllTags();
        List<TouristAttraction> getAllAttractions = touristService.getAllAttractions();

        TouristAttraction updateAttraction = new TouristAttraction();
        model.addAttribute("seasonTypes", getAllSeasons);
        model.addAttribute("getAllAttractions", getAllAttractions);
        model.addAttribute("getAllCities", getAllCities);
        model.addAttribute("updateAttraction", updateAttraction);
        model.addAttribute("getAllTags", getAllTags);
        return "updateAttraction";
    }

    @PostMapping("/attractions/update")
    public String processUpdate(@ModelAttribute TouristAttractionDTO dto) {
        TouristAttraction updatedAttraction = new TouristAttraction();

        updatedAttraction.setId(dto.getId());
        updatedAttraction.setName(dto.getName());
        updatedAttraction.setDescription(dto.getDescription());
        updatedAttraction.setImgPath(dto.getImgPath());

        updatedAttraction.setSeason(touristService.getSeasonFromID(dto.getId()));
        updatedAttraction.setCity(touristService.getCityFromID(dto.getCityID()));

        List<TagsModel> tags = new ArrayList<>();
        for (Integer i : dto.getTagsID()) {
            tags.add(touristService.getTagsFromID(i));
        }
        updatedAttraction.setTagsList(tags);

        touristService.updateAttraction(updatedAttraction);
        return "redirect:/updatedlist";
    }

    @PostMapping("/attractions/delete/{name}")
    public String removeAttraction(@PathVariable String name) {
        TouristAttraction deleteAttraction = touristService.removeAttraction(name);
        return "redirect:/attractions";
    }

    @GetMapping("/updatedlist")
    public String updateList() {
        return "updatedlist";
    }

    /*@GetMapping("/seasons/{name}")
    public String getAttractionBySeason(@PathVariable SeasonModel name, Model model) {
        List<TouristAttraction> attractionBySeason = touristService.getAttractionBySeason(name);
        model.addAttribute("attractionBySeason", attractionBySeason);
        return "attractionBySeason";
    }*/
}






