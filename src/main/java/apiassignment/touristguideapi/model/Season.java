package apiassignment.touristguideapi.model;

public enum Season {
    SOMMER("Sommer"),
    HELÅRS("Helårs"),
    VINTER("Vinter");


    private String displayName;

    Season(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
