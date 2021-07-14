package stpt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import stpt.entities.Trips;

import java.util.List;


public interface TripRepository extends JpaRepository<Trips,String>{
    @Query("SELECT DISTINCT tripHeadsign " +
            "FROM Trips t " +
            "WHERE (SELECT DISTINCT routeId " +
            "FROM Routes r " +
            "WHERE routeShortName IN (:short_name))=t.routeId")
    List<String> findByTripHeadsign(@Param("short_name")String short_name);
}
