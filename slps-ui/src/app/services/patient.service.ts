import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Patient} from "./patient";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>('http://localhost:8080/patient');
  }

  getByTherapistId(id: number): Observable<Patient[]> {
    let request: string = 'http://localhost:8080/patient/' + id;
    return this.http.get<Patient[]>(request);
  }
}
