package stpt.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stpt.Services.Services;
import stpt.entities.Routes;
import stpt.entities.Stops;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AppController {
    @Autowired
    private Services services;

    @GetMapping("/all")
    public @ResponseBody List<Stops> getAllStops() {
        return services.findAllStops();
    }


    @GetMapping("/stop/{stop_id}")
    public @ResponseBody Stops getStopsById(@PathVariable("stop_id") String stop_id){
        return services.findStopByID(stop_id);
    }

    @GetMapping("/test")
    public @ResponseBody List<Routes> getAllRoutes(){
        return services.findAllRoutes();
    }

    @GetMapping("/test/{trip_id}")
    public @ResponseBody List<String> getBySpecificTime(@PathVariable("trip_id") String id){
        return services.findBySpecificTime(id);
    }

    //Returneaza numarul tipului de vehicul ales

    @GetMapping("/{route_long_name}")
    public @ResponseBody List<String> getType(@PathVariable("route_long_name") String long_name){
        return services.findByRouteLongName(long_name);
    }
    //Returneaza statia finala a vehiculului ales (directia de mers)
    @GetMapping("/{route_long_name}/{route_short_name}")
    public @ResponseBody List<String> getHeading(@PathVariable("route_short_name") String short_name){
        return services.findByTripHeadsign(short_name);
    }
    //Returneaza statiile vehiculului cu directia de mers selectata deja
    @GetMapping("/{route_long_name}/{route_short_name}/{trip_headsign}")
    public @ResponseBody List<String> getStops(@PathVariable("route_short_name") String short_name,@PathVariable("trip_headsign") String headsign){
        return services.findByStops(short_name,headsign);
    }
    //Returneaza timpii de sosire ale vehiculului specific pentru ora actuala
    @GetMapping("/{route_long_name}/{route_short_name}/{trip_headsign}/{stop}")
    public @ResponseBody List<String> getByArrivalTime(@PathVariable("route_short_name") String short_name,@PathVariable("trip_headsign") String headsign,@PathVariable("stop") String stop){
        return services.findByArrivalTime(short_name,headsign,stop);
    }

}
