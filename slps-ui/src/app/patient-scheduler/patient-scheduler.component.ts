import {Component, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from "@angular/cdk/drag-drop";
import {HttpClient} from "@angular/common/http";

@Component({
    selector: 'slps-patient-scheduler',
    templateUrl: './patient-scheduler.component.html',
    styleUrls: ['./patient-scheduler.component.css']
})
export class PatientSchedulerComponent implements OnInit {
    patientPool: any;
    monday: any = [{firstName: 'Lunch'}];
    homeLocation: any = {latitude: 40.5623787, longitude: -79.93057259999999};

    constructor(private httpClient: HttpClient) {}

    drop(event: CdkDragDrop<string[]>) {
        if (event.previousContainer === event.container) {
            moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        } else {
            transferArrayItem(event.previousContainer.data, event.container.data, event.previousIndex,
                event.currentIndex);
        }
    }

    ngOnInit(): void {
        this.httpClient.get('http://localhost:8080/patient')
            .subscribe(data => this.patientPool = data);
    }
}
