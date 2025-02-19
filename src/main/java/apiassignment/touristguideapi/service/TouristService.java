package apiassignment.touristguideapi.service;

import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.model.Season;
import apiassignment.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getTouristAttracions();
    }

    public TouristAttraction getAttractionByName (String name) {
        return touristRepository.getAttractionByName(name);
    }

    public TouristAttraction addTouristAttraction (TouristAttraction t1) {
        return touristRepository.addNewAttraction(t1);
    }

    public TouristAttraction renameAttraction (TouristAttraction newTouristAttraction) {
        return touristRepository.renameAttraction(newTouristAttraction);
    }

    public TouristAttraction removeAttraction(String name) {
        return touristRepository.removeAttraction(name);
    }

    public ArrayList<TouristAttraction> getAttractionBySeason(Season season) {
        return touristRepository.getAttractionBySeason(season);
    }
}
