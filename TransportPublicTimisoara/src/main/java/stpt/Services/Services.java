package stpt.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stpt.Repository.RouteRepository;
import stpt.Repository.StopRepository;
import stpt.Repository.StopTimesRepository;
import stpt.Repository.TripRepository;
import stpt.entities.Routes;
import stpt.entities.Stops;

import java.util.List;

@Service
public class Services {
    @Autowired StopRepository stopRepository;
    @Autowired RouteRepository routeRepository;
    @Autowired TripRepository tripRepository;
    @Autowired StopTimesRepository stopTimesRepository;

    public List<Stops> findAllStops(){
        return stopRepository.findAll();
    }


    public Stops findStopByID(String id){
        return stopRepository.findByStopId(id);
    }

    public List<Routes> findAllRoutes(){
        return routeRepository.findAll();
    }

    public List<String> findBySpecificTime(String id){
        return stopTimesRepository.findBySpecificTime(id);
    }



    public List<String> findByRouteLongName(String long_name){

        return routeRepository.findByRouteLongName(long_name);
    }

    public List<String> findByTripHeadsign(String short_name){

        return tripRepository.findByTripHeadsign(short_name);
    }

    public List<String> findByStops(String short_name,String heading){
        return stopRepository.findByStops(short_name,heading);
    }

    public List<String> findByArrivalTime(String short_name,String heading,String stop){
        return stopTimesRepository.findByArrivalTime(short_name,heading,stop);
    }



}
