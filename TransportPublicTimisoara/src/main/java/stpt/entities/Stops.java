package stpt.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="stops")
@NoArgsConstructor
public class Stops {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stop_id")
    private String stopId;
    @Column(name = "stop_name")
    private String stopName;


    public String getStopId() {
        return this.stopId;
    }

    public String getStopName() {
        return this.stopName;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String toString() {
        return "Stops(stopId=" + this.getStopId() + ", stopName=" + this.getStopName() + ")";
    }
}
