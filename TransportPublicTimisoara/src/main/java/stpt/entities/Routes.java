package stpt.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "routes")
@NoArgsConstructor
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private String routeId;
    @Column(name = "route_short_name")
    private String routeShortName;
    @Column(name = "route_long_name")
    private String routeLongName;

    public String getRouteId() {
        return this.routeId;
    }

    public String getRouteShortName() {
        return this.routeShortName;
    }

    public String getRouteLongName() {
        return this.routeLongName;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public String toString() {
        return "Routes(routeId=" + this.getRouteId() + ", routeShortName=" + this.getRouteShortName() + ", routeLongName=" + this.getRouteLongName() + ")";
    }

}
