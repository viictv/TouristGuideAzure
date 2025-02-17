package apiassignment.touristguideapi.model;

import apiassignment.touristguideapi.repository.Season;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {

    private String name;
    private String description;
    private Season season; //ENUM klasse
    private String imgPath;
    private String city;
    private List<String> tagsList;

    public TouristAttraction(String name, String description, Season season, String imgPath, String city, List<String> tagsList) {
        this.name = name;
        this.description = description;
        this.season = season;
        this.imgPath = imgPath;
        this.city = city;
        this.tagsList = tagsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "TouristAttraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
