import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
    selector: 'slps-stats',
    templateUrl: './stats.component.html',
    styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {
    therapist: any;

    constructor(private httpClient: HttpClient) {
    }

    displayedColumns: string[] = ['firstName', 'lastName', 'location']

    ngOnInit(): void {
        this.httpClient.get('http://localhost:8080/patient/5')
            .subscribe(data => this.therapist = data);
    }
}
