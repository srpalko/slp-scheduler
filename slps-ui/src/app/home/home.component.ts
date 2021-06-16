import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
    selector: 'slps-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    patients: any;

    constructor(private httpClient: HttpClient) {
    }

    ngOnInit(): void {
        this.httpClient.get('http://localhost:8080/patient')
            .subscribe(data => this.patients = data);
    }
}
