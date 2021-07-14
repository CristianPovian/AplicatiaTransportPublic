import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  baseUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient, private router: Router) {}

  getType(type: string | null): Observable<any> {
    return this.http.get<any>(
      `${this.baseUrl}${type}`
    );
  }

  getType2(type: string | null, type2: string | null): Observable<any> {
    return this.http.get<any>(
      `${this.baseUrl}${type}/${type2}`
    );
  }

  getType3(type: string | null, type2: string | null, type3: string | null): Observable<any> {
    return this.http.get<any>(
      `${this.baseUrl}${type}/${type2}/${type3}`
    );
  }

  getType4(type: string | null, type2: string | null, type3: string | null, type4: string | null): Observable<any> {
    return this.http.get<any>(
      `${this.baseUrl}${type}/${type2}/${type3}/${type4}`
    );
  }
}
