package stpt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import stpt.entities.Routes;

import java.util.List;


public interface RouteRepository extends JpaRepository<Routes,String> {
    @Query("SELECT routeShortName " +
            "FROM Routes routes " +
            "WHERE routeLongName IN (:long_name)")
    List<String> findByRouteLongName(@Param("long_name") String long_name);
}
