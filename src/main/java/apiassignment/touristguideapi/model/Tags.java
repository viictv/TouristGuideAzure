package apiassignment.touristguideapi.model;

public enum Tags {
    UNDERHOLDNING("Underholdning"),
    ADRENALIN("Adrenalin"),
    MAD("Mad"),
    KUNST("Kunst"),
    KULTUR("Kultur"),
    HISTORIE("Historie"),
    SEVÆRDIGHEDER("Seværdigheder"),
    NATUR("Natur"),
    FORLYSTELSER("Forlystelser");

    private String displayName;

    Tags (String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName () {
        return displayName;
    }


}
