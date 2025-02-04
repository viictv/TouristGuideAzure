package apiassignment.touristguideapi.repository;

import java.util.ArrayList;
import java.util.List;

import apiassignment.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

@Repository
public class TouristRepository {

    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        initAttractions();
    }

    public List<TouristAttraction> getTouristAttracions() {
        return touristAttractions;
    }

    public void initAttractions() {
        touristAttractions.add(new TouristAttraction("navn", "beskrivelse", "Sommer"));
        touristAttractions.add(new TouristAttraction("navn2", "beskrivelse", "Sommer"));
        touristAttractions.add(new TouristAttraction("navn3", "beskrivelse", "Sommer"));
    }

    public TouristAttraction addNewAttraction (TouristAttraction t1) {
        touristAttractions.add(t1);
        return t1;
    }

    public TouristAttraction renameAttraction (String name, String replacementName) {
        for (TouristAttraction t1 : touristAttractions) {
            if (t1.getName().equalsIgnoreCase(name)) {
                t1.setName(replacementName);
                return t1;
            }
        }
        return null;
    }

    public TouristAttraction getAttractionByName (String name) {
        for (TouristAttraction t1 : touristAttractions) {
            if (t1.getName().equalsIgnoreCase(name)) return t1;
        }

        return null;
    }




}
