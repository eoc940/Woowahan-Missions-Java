package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    static final Station STATION_KYODAE = new Station("교대역");
    static final Station STATION_GANGNAM = new Station("강남역");
    static final Station STATION_YEOKSAM = new Station("역삼역");
    static final Station STATION_NAMBU_TERMINAL = new Station("남부터미널역");
    static final Station STATION_YANGJAE = new Station("양재역");
    static final Station STATION_YANGJAE_FOREST = new Station("양재시민의숲역");
    static final Station STATION_MAEBONG = new Station("매봉역");

    public static List<Station> stations() {
        addStation(STATION_KYODAE);
        addStation(STATION_GANGNAM);
        addStation(STATION_YEOKSAM);
        addStation(STATION_NAMBU_TERMINAL);
        addStation(STATION_YANGJAE);
        addStation(STATION_YANGJAE_FOREST);
        addStation(STATION_MAEBONG);
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        for (Station enrolledStation : stations) {
            if (enrolledStation.getName().equals(station.getName())) {
                return;
            }
        }
        stations.add(station);
    }

    public static void deleteStation(String name) {
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
//ddd






            //ll






        //l


        //s
