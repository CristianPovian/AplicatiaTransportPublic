import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  route_long_name = this.route.snapshot.paramMap.get('route_long_name');
  route_short_name = this.route.snapshot.paramMap.get('route_short_name');
  trip_headsign = this.route.snapshot.paramMap.get('trip_headsign');
  stop = this.route.snapshot.paramMap.get('stop');

  types = [];
  lastData: Boolean = false;

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    if (this.route_long_name && !this.route_short_name && !this.trip_headsign && !this.stop) {
      this.apiService.getType(this.route_long_name).subscribe((res) => {
        this.types = res;
      });
    }

    if (this.route_long_name && this.route_short_name && !this.trip_headsign && !this.stop) {
      this.apiService.getType2(this.route_long_name, this.route_short_name).subscribe((res) => {
        this.types = res;
      });
    }

    if (this.route_long_name && this.route_short_name && this.trip_headsign && !this.stop) {
      this.apiService.getType3(this.route_long_name, this.route_short_name, this.trip_headsign).subscribe((res) => {
        this.types = res;
      });
    }

    if (this.route_long_name && this.route_short_name && this.trip_headsign && this.stop) {
      this.apiService.getType4(this.route_long_name, this.route_short_name, this.trip_headsign, this.stop).subscribe((res) => {
        this.types = res;
        this.lastData = true;
      });
    }
  }

  inspect(pararm: string) {
    this.router.navigate([pararm], { relativeTo: this.route })
  }

  navigateBack() {
    if (this.route_long_name && !this.route_short_name && !this.trip_headsign && !this.stop) {
      this.router.navigate([".."]);
    } else {
      this.router.navigate([".."], { relativeTo: this.route });
    }
  }

  message(): string {
    let msg: string = '1';
    if (this.route_long_name && !this.route_short_name && !this.trip_headsign && !this.stop) {
      msg = 'Alegeti linia cu care doriți să vă deplasați'
    }

    if (this.route_long_name && this.route_short_name && !this.trip_headsign && !this.stop) {
      msg = 'Alegeți direcția de mers al mijlocului de transport'
    }

    if (this.route_long_name && this.route_short_name && this.trip_headsign && !this.stop) {
      msg = 'Alegeți stația la care vă aflați acum'
    }

    if (this.route_long_name && this.route_short_name && this.trip_headsign && this.stop) {
      msg = `Timpii de sosire pentru ${this.route_long_name} ${this.route_short_name} în stația ${this.stop} pentru următoarele 2 ore sunt:`
    }
    return msg;
  }

}
