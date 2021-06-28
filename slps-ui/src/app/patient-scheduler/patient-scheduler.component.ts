import {Component, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from "@angular/cdk/drag-drop";
import {PatientService} from "../services/patient.service";
import {Patient} from "../services/patient";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Schedule} from "./schedule";
import {TherapistService} from "../services/therapist.service";
import {GeometryService} from "../services/geometry.service";

@Component({
    selector: 'slps-patient-scheduler',
    templateUrl: './patient-scheduler.component.html',
    styleUrls: ['./patient-scheduler.component.css']
})
export class PatientSchedulerComponent implements OnInit {
    patientPool: Patient[] = [];
    schedule: Schedule = new class implements Schedule {
        friday: Patient[] = [];
        monday: Patient[] = [];
        thursday: Patient[] = [];
        tuesday: Patient[] = [];
        wednesday: Patient[] = [];
    };
    homeX = 0;
    homeY = 0;

    constructor(private patientService: PatientService, private therapistService: TherapistService,
                private http: HttpClient, private geo: GeometryService) {
    }

    drop(event: CdkDragDrop<any>) {
        if (event.previousContainer === event.container) {
            moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        } else {
            transferArrayItem(event.previousContainer.data, event.container.data, event.previousIndex,
                event.currentIndex);
        }
    }

    ngOnInit(): void {
        this.patientService.getByTherapistId(10).subscribe(data => this.patientPool = data);
        this.therapistService.getSchedule(10).subscribe(data => this.schedule = data);
        this.patientPool.forEach(patient => {
            patient.testX = Math.random() * 10;
            patient.testY = Math.random() * 10;
        })
        this.patientPool.forEach(patient => {
            patient.distance = this.geo.findDistance(this.homeX, this.homeY, patient.testX, patient.testY);
            console.log("Patient distance" + patient.distance);
        })
    }

    saveSchedule() {
        const headers = new HttpHeaders().set("Content-Type", "application/json");
        this.http.put<Schedule>("http://localhost:8080/patient/addSchedule/10",
            this.schedule, {headers}).subscribe(val => {
            this.schedule = val
        });
    }
}
