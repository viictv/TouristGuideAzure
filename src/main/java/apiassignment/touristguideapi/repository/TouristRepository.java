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
        touristAttractions.add(new TouristAttraction("Tivoli", "Varmeste forlystelse", "Sommer"));
        touristAttractions.add(new TouristAttraction("SMK", "Very demur art", "Sommer"));
        touristAttractions.add(new TouristAttraction("Nyhavn", "Majestic Aura place", "Sommer"));
    }

    public TouristAttraction addNewAttraction (TouristAttraction t1) {
        touristAttractions.add(t1);
        return t1;
    }

    public TouristAttraction renameAttraction (TouristAttraction newTouristAttraction) {
        TouristAttraction t1 = null;
        for(TouristAttraction i : getTouristAttracions()) {
            if(i.getName().equalsIgnoreCase(newTouristAttraction.getName())) {
                i.setDescription(newTouristAttraction.getDescription());
                t1 = i;
            } else if (i.getDescription().equalsIgnoreCase(newTouristAttraction.getDescription())) {
                i.setName(newTouristAttraction.getName());
                t1 = i;
            }
        }
        return t1;
    }

    public TouristAttraction getAttractionByName (String name) {
        for (TouristAttraction t1 : touristAttractions) {
            if (t1.getName().equalsIgnoreCase(name))
                return t1;
        }
        return null;
    }

    public TouristAttraction removeAttraction(String name) {
        for(TouristAttraction i : touristAttractions) {
            if(i.getName().equalsIgnoreCase(name)) {
                touristAttractions.remove(i);
                return i;
            }
        }
        return null;
    }

    public ArrayList<TouristAttraction> getAttractionBySeason(String season) {
        ArrayList<TouristAttraction> newList = new ArrayList<>();
        for(TouristAttraction t1 : touristAttractions) {
            if(t1.getSeason().equalsIgnoreCase(season)) {
                newList.add(t1);
            }
        }
        return newList;
    }


}
