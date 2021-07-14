package stpt.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "stop_times")
@NoArgsConstructor
public class StopTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trip_id")
    private String tripId;
    @Column(name = "arrival_time")
    private String arrivalTime;
    @Column(name = "stop_id")
    private String stopId;
    @Column(name = "stop_sequence")
    private int stopSequence;

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public int getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(int stopSequence) {
        this.stopSequence = stopSequence;
    }

    @Override
    public String toString() {
        return "StopTimes{" +
                "tripId='" + tripId + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", stopId='" + stopId + '\'' +
                ", stopSequence=" + stopSequence +
                '}';
    }
}
