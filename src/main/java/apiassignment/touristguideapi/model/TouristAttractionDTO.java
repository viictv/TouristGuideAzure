package apiassignment.touristguideapi.model;

import java.util.List;

public class TouristAttractionDTO {

    private int id;
    private String name;
    private String description;
    private String imgPath;
    private int seasonID;
    private int cityID;
    private List<Integer> tagsID;

    public TouristAttractionDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getSeasonID() {
        return seasonID;
    }

    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public List<Integer> getTagsID() {
        return tagsID;
    }

    public void setTagsID(List<Integer> tagsID) {
        this.tagsID = tagsID;
    }
}
