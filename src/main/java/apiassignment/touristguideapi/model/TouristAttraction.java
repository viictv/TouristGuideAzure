package apiassignment.touristguideapi.model;
import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {

    private String name;
    private String description;
    private Season season;
    private String imgPath;
    private String city;
    private List<Tags> tagsList = new ArrayList<>();

    public TouristAttraction(String name, String description, Season season, String imgPath, String city, List<Tags> tagsList) {
        this.name = name;
        this.description = description;
        this.season = season;
        this.imgPath = imgPath;
        this.city = city;
        this.tagsList = tagsList;
    }

    public TouristAttraction() {

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    @Override
    public String toString() {
        return "TouristAttraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", season=" + season +
                ", imgPath='" + imgPath + '\'' +
                ", city='" + city + '\'' +
                ", tagsList=" + tagsList +
                '}';
    }

}
