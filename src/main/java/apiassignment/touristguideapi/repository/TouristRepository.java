package apiassignment.touristguideapi.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import apiassignment.touristguideapi.model.CityModel;
import apiassignment.touristguideapi.model.SeasonModel;
import apiassignment.touristguideapi.model.TagsModel;
import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.rowmappers.AttractionRowMapper;
import apiassignment.touristguideapi.rowmappers.CityRowMapper;
import apiassignment.touristguideapi.rowmappers.SeasonRowMapper;
import apiassignment.touristguideapi.rowmappers.TagsRowMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Repository
public class TouristRepository {

    private final List<TouristAttraction> touristAttractions = new ArrayList<>();
    private final List<String> allCities = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;

    public TouristRepository() {
        /*DriverManagerDataSource dataSource = new DriverManagerDataSource(
                url, username, password
        );*/
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                System.getenv("PROD_DATABASE_URL"),
                System.getenv("PROD_USERNAME"),
                System.getenv("PROD_PASSWORD")
        );

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        /*initAttractions();
        initCities();*/
    }


    public List<TouristAttraction> getTouristAttractions() {
        String sql = "SELECT * FROM attraction";
        return jdbcTemplate.query(sql, new AttractionRowMapper());
        /*try {

        } catch (DataAccessException e) {
            System.out.println(e);
            return Collections.emptyList();
        }*/
        /*return touristAttractions;*/
    }

    /*private void initAttractions() {
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

    }*/

    public TouristAttraction addNewAttraction (TouristAttraction t1) {
        String sql = "INSERT INTO attraction (NAME, DESCRIPTION, IMAGE_PATH, Season_ID, City_ID) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, t1.getName());
            ps.setString(2, t1.getDescription());
            ps.setString(3, t1.getImgPath());
            ps.setInt(4, t1.getSeason().getId());
            ps.setInt(5, t1.getCity().getId());

            return ps;
        }, keyHolder);

        t1.setId(keyHolder.getKey().intValue());

        String tagsSql = "INSERT INTO attraction_tags (ATTRACTION_ID, TAGS_ID) VALUES (?, ?)";
        for (TagsModel tag : t1.getTagsList()) {
            jdbcTemplate.update(tagsSql, t1.getId(), tag.getId());
        }
        return t1;
    }

    /*
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

     */

    public TouristAttraction renameAttraction(TouristAttraction newTouristAttraction) {
        String sql = "UPDATE touristguide_attraction SET description = ?, img_path = ?, season = ?, tags_list = ? WHERE name = ?";

        int rowsUpdated = jdbcTemplate.update(sql,
                newTouristAttraction.getDescription(),
                newTouristAttraction.getImgPath(),
                newTouristAttraction.getSeason(),
                newTouristAttraction.getTagsList(),
                newTouristAttraction.getName()
        );

        if (rowsUpdated > 0) {
            System.out.println("Attraction updated: " + newTouristAttraction.getName());
            return newTouristAttraction;
        } else {
            throw new RuntimeException("Attraction not found: " + newTouristAttraction.getName());
        }
    }

    public TouristAttraction getAttractionByName (String name) {


        String sql = "SELECT * FROM attraction WHERE name = ?";
        List<TouristAttraction> templist = jdbcTemplate.query(sql, new AttractionRowMapper(), name);

        if (templist.isEmpty() || templist == null) return null;
        return templist.get(0);


        /*for (TouristAttraction t1 : touristAttractions) {
            if (t1.getName().equalsIgnoreCase(name))
                return t1;
        }
        return null;*/
    }

    public TouristAttraction removeAttraction(String name) {
        TouristAttraction toDelete = getAttractionByName(name);
        if (toDelete != null) {
            String sql = "DELETE FROM attraction WHERE NAME = ?";
            jdbcTemplate.update(sql, name);
        }
        return toDelete;

        /*for(TouristAttraction touristAttraction : touristAttractions) {
            if(touristAttraction.getName().equalsIgnoreCase(name)) {
                touristAttractions.remove(touristAttraction);
                return touristAttraction;
            }
        }*/
    }

    /*public ArrayList<TouristAttraction> getAttractionBySeason(Season season) {

        String sql = "SELECT * attraction WHERE Season_ID = ?";
        jdbcTemplate.upd

        ArrayList<TouristAttraction> newList = new ArrayList<>();
        for(TouristAttraction t1 : touristAttractions) {
            if(t1.getSeason().equals(season)) {
                newList.add(t1);
            }
        }
        return newList;
    }*/



    /*public List<TagsModel> getTagsByAttractionID(int attractionID) {
        String sql = """
                    SELECT t.*
                    FROM tags t
                    JOIN attraction_tags at ON t.TagsID = at.TagsID
                    WHERE at.AttractionsAttractionID = ?""";
    }*/

    public List<CityModel> getCities () {
        String sql = "SELECT * FROM city";
        return jdbcTemplate.query(sql, new CityRowMapper());
    }

    public List<SeasonModel> getSeasons () {
        String sql = "SELECT * FROM season";
        return jdbcTemplate.query(sql, new SeasonRowMapper());
    }

    public List<TagsModel> getTags () {
        String sql = "SELECT * FROM tags";
        return jdbcTemplate.query(sql, new TagsRowMapper());
    }






}
