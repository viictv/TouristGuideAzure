package apiassignment.touristguideapi.model;
import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private int id;
    private String name;
    private String description;
    private String imgPath;
    private int seasonId;
    private int cityId;
    private List<TagsModel> tagsList = new ArrayList<>();

    public TouristAttraction(String name, String description, int seasonId, String imgPath, int cityId, List<TagsModel> tagsList) {
        this.name = name;
        this.description = description;
        this.seasonId  = seasonId;
        this.imgPath = imgPath;
        this.cityId = cityId;
        this.tagsList = tagsList;
    }
    public TouristAttraction(String name, String description, String imgPath) {
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
    }

    public TouristAttraction() {

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

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public List<TagsModel> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<TagsModel> tagsList) {
        this.tagsList = tagsList;
    }

    @Override
    public String toString() {
        return "TouristAttraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", season=" + seasonId +
                ", imgPath='" + imgPath + '\'' +
                ", city='" + cityId + '\'' +
                ", tagsList=" + tagsList +
                '}';
    }

}
