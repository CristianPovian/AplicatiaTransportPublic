import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  transportTypeArray = [
    {
      label: 'Autobuze',
      value: 'Autobuz'
    },
    {
      label: 'Express',
      value: 'Express'
    },
    {
      label: 'Metropolitane',
      value: 'Metropolitan'
    },
    {
      label: 'Scoala',
      value: 'Scoala'
    }, {
      label: 'Tramvaie',
      value: 'Tramvai'
    }, {
      label: 'Troleibuze',
      value: 'Troleibuz'
    }];

    id = 'asd';

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    // this.apiService.getType(this.id).subscribe((res) => {
    //   console.log(res)
    // });
  }

  inspectType(route_long_name: string){  
    this.router.navigate(['info', route_long_name])
  }

}
