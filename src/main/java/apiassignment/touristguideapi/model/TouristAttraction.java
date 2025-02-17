package apiassignment.touristguideapi.model;

public class TouristAttraction {

    private String name;
    private String description;
    private String season;
    private String imgPath;

    public TouristAttraction(String name, String description, String season, String imgPath) {
        this.name = name;
        this.description = description;
        this.season = season;
        this.imgPath = imgPath;
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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
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
