import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Therapist} from "./therapist";
import {Schedule} from "../patient-scheduler/schedule";

@Injectable({
    providedIn: 'root'
})
export class TherapistService {
    constructor(private http: HttpClient) {
    }

    getById(therapistId: number): Observable<Therapist> {
        return this.http.get<Therapist>('http://localhost:8080/patient/getTherapist/' + therapistId);
    }

    getSchedule(therapistId: number): Observable<Schedule> {
        return this.http.get<Schedule>('http://localhost:8080/patient/getSchedule/' + therapistId);
    }
}
