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
            touristAttractions.add(new TouristAttraction(
                    "Tivoli",
                    "Tivoli er en af verdens ældste forlystelsesparker, beliggende i hjertet af København. Parken tilbyder en blanding af spændende forlystelser, smukke haver, koncerter og teaterforestillinger, hvilket gør det til et ideelt sted for både familier og turister, der ønsker en sjov og magisk oplevelse.",
                    Season.SOMMER,
                    "/images/Tivoli.jpg",
                    "København",
                    List.of("Underholdning", "Adrenalin", "Mad") // Using List.of for tags
            ));

            touristAttractions.add(new TouristAttraction(
                    "SMK",
                    "Statens Museum for Kunst er Danmarks største kunstmuseum og huser en imponerende samling af både dansk og international kunst. Museet tilbyder værker fra renæssancen til moderne kunst og giver besøgende mulighed for at udforske både klassiske og nutidige kunstværker i smukke omgivelser.",
                    Season.HELÅRS,
                    "https://www.smk.dk/wp-content/uploads/2022/08/JoakimZuger03141-scaled-e1716369338667.jpg",
                    "København",
                    List.of("Kunst", "Kultur", "Historie")
            ));

            touristAttractions.add(new TouristAttraction(
                    "Nyhavn",
                    "Nyhavn er en ikonisk havn i København, kendt for sine farverige bygninger og livlige atmosfære. Området er fyldt med restauranter, barer og caféer, og det er et populært sted for både lokale og turister at nyde en afslappet middag eller tage en kanalrundfart i de charmerende både.",
                    Season.HELÅRS,
                    "/images/istockphoto-587892190-612x612.jpg",
                    "København",
                    List.of("Seværdigheder", "Mad", "Kultur")
            ));

            touristAttractions.add(new TouristAttraction(
                    "Legoland",
                    "Legoland Billund er en fantastisk forlystelsespark, der byder på spændende oplevelser for både børn og voksne. Parken er kendt for sine imponerende LEGO-modeller, forlystelser og temazoner, der gør det til et sjovt og fantasifuldt sted for hele familien at udforske og nyde.",
                    Season.SOMMER,
                    "https://www.legoland.dk/media/joclxhf1/136-legoland__k1a2849_final_1920x1080.jpg",
                    "Billund",
                    List.of("Lego", "Kunst")
            ));

            touristAttractions.add(new TouristAttraction(
                    "Skovtårnet",
                    "Skovtårnet er Danmarks højeste træbygning og tilbyder en spektakulær udsigt over Smålandskovene. Tårnet er en del af Camp Adventure Park og giver besøgende mulighed for at opleve naturen fra et nyt perspektiv, mens man går op ad en imponerende gangbro, der snor sig op til toppen af tårnet.",
                    Season.SOMMER,
                    "https://files.guidedanmark.org/files/444/219094_Skovtrnet_8.jpg?width=1920&height=960&format=webp&mode=crop",
                    "Gisselfeld Kloster",
                    List.of("Frisk luft", "Højdeskræk")
            ));

            touristAttractions.add(new TouristAttraction(
                    "BonBon-Land",
                    "BonBon-Land er en farverig forlystelsespark i Danmark, kendt for sine sjove og kreative forlystelser, inspireret af det populære slikmærke. Parken tilbyder et væld af forlystelser, fra vilde rutsjebaner til tematiserede områder, der gør det til et underholdende sted for både børn og voksne.",
                    Season.SOMMER,
                    "https://www.bonbonland.dk/content/dam/bbl/images/blog/Bedste%20rutchebane.jpg",
                    "Holme-Olstrup",
                    List.of("Adrenalin", "Forlystelser")
            ));

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

    public ArrayList<TouristAttraction> getAttractionBySeason(Season season) {

        ArrayList<TouristAttraction> newList = new ArrayList<>();
        for(TouristAttraction t1 : touristAttractions) {
            if(t1.getSeason().equals(season)) {
                newList.add(t1);
            }
        }
        return newList;
    }



}
