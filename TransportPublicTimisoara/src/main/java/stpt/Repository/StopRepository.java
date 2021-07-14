package stpt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stpt.entities.Stops;

import java.util.List;

@Repository
public interface StopRepository extends JpaRepository<Stops, String> {
    Stops findByStopId(String stop_id);
    @Query("SELECT DISTINCT s.stopName FROM Stops s, StopTimes st, " +
            "Trips t, Routes r " +
            "WHERE s.stopId=st.stopId " +
            "AND st.tripId=t.tripId " +
            "AND t.tripHeadsign IN (:headsign) " +
            "AND t.routeId=r.routeId " +
            "AND r.routeShortName IN (:short_name)")
    List<String> findByStops(@Param("short_name") String short_name,
                             @Param("headsign") String headsign);
}