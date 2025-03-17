package apiassignment.touristguideapi.repository;

import java.util.ArrayList;
import java.util.List;

import apiassignment.touristguideapi.model.Season;
import apiassignment.touristguideapi.model.Tags;
import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.rowmappers.AttractionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Repository
public class TouristRepository {

    private final List<TouristAttraction> touristAttractions = new ArrayList<>();
    private final List<String> allCities = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;


    public TouristRepository() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                System.getenv("DATABASE_URL"),
                System.getenv("USERNAME"),
                System.getenv("PASSWORD")
        );
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        initAttractions();
        initCities();
    }


    public List<TouristAttraction> getTouristAttractions() {
        String sql = "SELECT * FROM attraction";
        return jdbcTemplate.query(sql, new AttractionRowMapper());
        /*return touristAttractions;*/
    }

    private void initAttractions() {
            touristAttractions.add(new TouristAttraction(
                    "Tivoli",
                    "Tivoli er en af verdens ældste forlystelsesparker, beliggende i hjertet af København. Parken tilbyder en blanding af spændende forlystelser, smukke haver, koncerter og teaterforestillinger, hvilket gør det til et ideelt sted for både familier og turister, der ønsker en sjov og magisk oplevelse.",
                    Season.SOMMER,
                    "/images/Tivoli.jpg",
                    "København",
                    List.of(Tags.UNDERHOLDNING, Tags.ADRENALIN, Tags.MAD)
            ));

            touristAttractions.add(new TouristAttraction(
                    "SMK",
                    "Statens Museum for Kunst er Danmarks største kunstmuseum og huser en imponerende samling af både dansk og international kunst. Museet tilbyder værker fra renæssancen til moderne kunst og giver besøgende mulighed for at udforske både klassiske og nutidige kunstværker i smukke omgivelser.",
                    Season.HELÅRS,
                    "https://www.smk.dk/wp-content/uploads/2022/08/JoakimZuger03141-scaled-e1716369338667.jpg",
                    "København",
                    List.of(Tags.KUNST, Tags.KULTUR, Tags.HISTORIE)
            ));

            touristAttractions.add(new TouristAttraction(
                    "Nyhavn",
                    "Nyhavn er en ikonisk havn i København, kendt for sine farverige bygninger og livlige atmosfære. Området er fyldt med restauranter, barer og caféer, og det er et populært sted for både lokale og turister at nyde en afslappet middag eller tage en kanalrundfart i de charmerende både.",
                    Season.HELÅRS,
                    "/images/istockphoto-587892190-612x612.jpg",
                    "København",
                    List.of(Tags.SEVÆRDIGHEDER, Tags.MAD, Tags.KULTUR)
            ));

            touristAttractions.add(new TouristAttraction(
                    "Legoland",
                    "Legoland Billund er en fantastisk forlystelsespark, der byder på spændende oplevelser for både børn og voksne. Parken er kendt for sine imponerende LEGO-modeller, forlystelser og temazoner, der gør det til et sjovt og fantasifuldt sted for hele familien at udforske og nyde.",
                    Season.SOMMER,
                    "https://www.legoland.dk/media/joclxhf1/136-legoland__k1a2849_final_1920x1080.jpg",
                    "Billund",
                    List.of(Tags.UNDERHOLDNING, Tags.KUNST)
            ));

            touristAttractions.add(new TouristAttraction(
                    "Skovtårnet",
                    "Skovtårnet er Danmarks højeste træbygning og tilbyder en spektakulær udsigt over Smålandskovene. Tårnet er en del af Camp Adventure Park og giver besøgende mulighed for at opleve naturen fra et nyt perspektiv, mens man går op ad en imponerende gangbro, der snor sig op til toppen af tårnet.",
                    Season.SOMMER,
                    "https://files.guidedanmark.org/files/444/219094_Skovtrnet_8.jpg?width=1920&height=960&format=webp&mode=crop",
                    "Gisselfeld Kloster",
                    List.of(Tags.NATUR, Tags.SEVÆRDIGHEDER)
            ));

            touristAttractions.add(new TouristAttraction(
                    "BonBon-Land",
                    "BonBon-Land er en farverig forlystelsespark i Danmark, kendt for sine sjove og kreative forlystelser, inspireret af det populære slikmærke. Parken tilbyder et væld af forlystelser, fra vilde rutsjebaner til tematiserede områder, der gør det til et underholdende sted for både børn og voksne.",
                    Season.SOMMER,
                    "https://www.bonbonland.dk/content/dam/bbl/images/blog/Bedste%20rutchebane.jpg",
                    "Holme-Olstrup",
                    List.of(Tags.ADRENALIN, Tags.FORLYSTELSER)
            ));

    }

    public TouristAttraction addNewAttraction (TouristAttraction t1) {
        touristAttractions.add(t1);
        return t1;
    }

    public TouristAttraction renameAttraction (TouristAttraction newTouristAttraction) {
        TouristAttraction t1 = null;
        for(TouristAttraction touristAttraction : getTouristAttractions()) {
            if(touristAttraction.getName().equalsIgnoreCase(newTouristAttraction.getName())) {
                touristAttraction.setDescription(newTouristAttraction.getDescription());
                touristAttraction.setImgPath(newTouristAttraction.getImgPath());
                touristAttraction.setSeason(newTouristAttraction.getSeason());
                touristAttraction.setTagsList(newTouristAttraction.getTagsList());
                t1 = touristAttraction;
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
        for(TouristAttraction touristAttraction : touristAttractions) {
            if(touristAttraction.getName().equalsIgnoreCase(name)) {
                touristAttractions.remove(touristAttraction);
                return touristAttraction;
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

    //Sofie cooking
    public List<Tags> getTagsByAttractionName(String attractionName) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(attractionName)) {
                return attraction.getTagsList();
            }
        }
        return null;
    }

    private void initCities() {
        allCities.add("København Ø");
        allCities.add("København V");
        allCities.add("Søborg");
        allCities.add("Ishøj");
        allCities.add("Brønshæj");
    }

    public List<String> getCities() {
        return allCities;
    }



}
