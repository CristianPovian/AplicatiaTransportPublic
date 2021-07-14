package stpt.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import stpt.entities.StopTimes;


import java.util.List;

public interface StopTimesRepository extends Repository<StopTimes,String> {
    @Query("SELECT arrivalTime FROM StopTimes st WHERE tripId IN (:id)")
    List<String> findBySpecificTime(@Param("id") String id);
    @Query(value = "SELECT distinct arrival_time\n" +
            "FROM stop_times st, trips t, routes r, stops s \n" +
            "WHERE r.route_short_name=:short_name\n" +
            "AND t.trip_headsign=:heading\n" +
            "AND st.trip_id=t.trip_id\n" +
            "AND t.route_id=r.route_id \n" +
            "AND s.stop_id=st.stop_id\n" +
            "AND IF(DAYOFWEEK(CURDATE())=7 OR DAYOFWEEK(CURDATE())=1, t.service_id LIKE '%-sd', t.service_id LIKE '%-lv')\n" +
            "AND IF(HOUR(CURTIME())=1, st.arrival_time LIKE '1:%' OR st.arrival_time LIKE '2:%',4)\n" +
            "AND IF(HOUR(CURTIME())=2, st.arrival_time LIKE '2:%' OR st.arrival_time LIKE '3:%',4)\n" +
            "AND IF(HOUR(CURTIME())=3, st.arrival_time LIKE '3:%' OR st.arrival_time LIKE '4:%',4)\n" +
            "AND IF(HOUR(CURTIME())=4, st.arrival_time LIKE '4:%' OR st.arrival_time LIKE '5:%',4)\n" +
            "AND IF(HOUR(CURTIME())=5, st.arrival_time LIKE '5:%' OR st.arrival_time LIKE '6:%',5)\n" +
            "AND IF(HOUR(CURTIME())=6, st.arrival_time LIKE '6:%' OR st.arrival_time LIKE '7:%',6)\n" +
            "AND IF(HOUR(CURTIME())=7, st.arrival_time LIKE '7:%' OR st.arrival_time LIKE '8:%',7)\n" +
            "AND IF(HOUR(CURTIME())=8, st.arrival_time LIKE '8:%' OR st.arrival_time LIKE '9:%',8)\n" +
            "AND IF(HOUR(CURTIME())=9, st.arrival_time LIKE '9:%' OR st.arrival_time LIKE '10:%',9)\n" +
            "AND IF(HOUR(CURTIME())=10, st.arrival_time LIKE '10:%' OR st.arrival_time LIKE '11:%',10)\n" +
            "AND IF(HOUR(CURTIME())=11, st.arrival_time LIKE '11:%' OR st.arrival_time LIKE '12:%',11)\n" +
            "AND IF(HOUR(CURTIME())=12, st.arrival_time LIKE '12:%' OR st.arrival_time LIKE '13:%',12)\n" +
            "AND IF(HOUR(CURTIME())=13, st.arrival_time LIKE '13:%' OR st.arrival_time LIKE '14:%',13)\n" +
            "AND IF(HOUR(CURTIME())=14, st.arrival_time LIKE '14:%' OR st.arrival_time LIKE '15:%',14)\n" +
            "AND IF(HOUR(CURTIME())=15, st.arrival_time LIKE '15:%' OR st.arrival_time LIKE '16:%',15)\n" +
            "AND IF(HOUR(CURTIME())=16, st.arrival_time LIKE '16:%' OR st.arrival_time LIKE '17:%',16)\n" +
            "AND IF(HOUR(CURTIME())=17, st.arrival_time LIKE '17:%' OR st.arrival_time LIKE '18:%',17)\n" +
            "AND IF(HOUR(CURTIME())=18, st.arrival_time LIKE '18:%' OR st.arrival_time LIKE '19:%',18)\n" +
            "AND IF(HOUR(CURTIME())=19, st.arrival_time LIKE '19:%' OR st.arrival_time LIKE '20:%',19)\n" +
            "AND IF(HOUR(CURTIME())=20, st.arrival_time LIKE '20:%' OR st.arrival_time LIKE '21:%',20)\n" +
            "AND IF(HOUR(CURTIME())=21, st.arrival_time LIKE '21:%' OR st.arrival_time LIKE '22:%',21)\n" +
            "AND IF(HOUR(CURTIME())=22, st.arrival_time LIKE '22:%' OR st.arrival_time LIKE '23:%',22)\n" +
            "AND IF(HOUR(CURTIME())=23, st.arrival_time LIKE '23:%' OR st.arrival_time LIKE '24:%',23)\n" +
            "AND IF(HOUR(CURTIME())=0, st.arrival_time LIKE '24:%',24)\n" +
            "AND s.stop_name=:stop\n" +
            "ORDER BY arrival_time ASC",nativeQuery = true)
    List<String> findByArrivalTime(@Param("short_name") String short_name, @Param("heading") String heading, @Param("stop") String stop);

}
