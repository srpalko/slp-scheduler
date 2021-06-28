import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {Patient} from "../services/patient";
import {PatientService} from "../services/patient.service";
import {TherapistService} from "../services/therapist.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
    selector: 'slps-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    patients$: Observable<Patient[]>;
    therapist$: any;
    selectedPatients: any[] = [];

    constructor(private patientService: PatientService, private therapistService: TherapistService,
                private router: Router, private httpClient: HttpClient) {
        this.patients$ = patientService.getAll();
    }

    displayedColumns: string[] = ['firstName', 'addButton'];

    ngOnInit() {
    }

    updateTherapist(patient: any, event: any) {
        if (event.target.checked) {
            this.selectedPatients.push(patient);
            console.log(this.selectedPatients);
        } else {
            this.selectedPatients.splice(this.selectedPatients.findIndex((i: any) => i === patient), 1);
        }
    }

    onSubmit() {
        this.selectedPatients.forEach(patient => patient.assigned = true);
        this.httpClient.put<string>('http://localhost:8080/patient/10',
            this.selectedPatients,
            {headers: new HttpHeaders().set('Content-type', 'application/json')}
        ).subscribe(data => this.patients$ = this.patientService.getAll());

    }
}
