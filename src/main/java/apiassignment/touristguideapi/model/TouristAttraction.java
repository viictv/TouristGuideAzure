package apiassignment.touristguideapi.model;

public class TouristAttraction {

    private String name;
    private String description;
    private String season;

    public TouristAttraction(String name, String description, String season) {
        this.name = name;
        this.description = description;
        this.season = season;
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

    @Override
    public String toString() {
        return "TouristAttraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
