import {Component, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from "@angular/cdk/drag-drop";

@Component({
    selector: 'slps-patient-scheduler',
    templateUrl: './patient-scheduler.component.html',
    styleUrls: ['./patient-scheduler.component.css']
})
export class PatientSchedulerComponent implements OnInit {
    patientPool = ['patient1', 'patient2', 'patient3'];
    monday = ['patient4', 'patient5'];

    drop(event: CdkDragDrop<string[]>) {
        if (event.previousContainer === event.container) {
            moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        } else {
            transferArrayItem(event.previousContainer.data, event.container.data, event.previousIndex,
                event.currentIndex);
        }
    }

    ngOnInit(): void {}
}
