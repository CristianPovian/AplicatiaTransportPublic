package stpt.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "trips")
@NoArgsConstructor
public class Trips {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private String routeId;
    @Column(name = "service_id")
    private String serviceId;
    @Column(name = "trip_id")
    private String tripId;
    @Column(name = "trip_headsign")
    private String tripHeadsign;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    @Override
    public String toString() {
        return "Trips{" +
                "routeId='" + routeId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", tripId='" + tripId + '\'' +
                ", tripHeadsign='" + tripHeadsign + '\'' +
                '}';
    }
}
