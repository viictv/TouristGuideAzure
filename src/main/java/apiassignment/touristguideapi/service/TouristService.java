package apiassignment.touristguideapi.service;

import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

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

    public TouristAttraction renameAttraction (String name, String replacementName) {
        return touristRepository.renameAttraction(name, replacementName);

    }


}
