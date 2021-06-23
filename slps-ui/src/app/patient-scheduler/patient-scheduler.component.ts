import {Component, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from "@angular/cdk/drag-drop";
import {PatientService} from "../services/patient.service";
import {Patient} from "../services/patient";

@Component({
    selector: 'slps-patient-scheduler',
    templateUrl: './patient-scheduler.component.html',
    styleUrls: ['./patient-scheduler.component.css']
})
export class PatientSchedulerComponent implements OnInit {
    patientPool: Patient[] = [];
    monday: Patient[] = [];

    constructor(private patientService: PatientService) {
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
        this.patientService.getByTherapistId(5).subscribe(data => this.patientPool = data)
    }
}
