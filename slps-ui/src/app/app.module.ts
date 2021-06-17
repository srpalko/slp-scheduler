import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import { ToolbarComponent } from './toolbar/toolbar.component';
import {HttpClientModule} from "@angular/common/http";
import {ApiService} from "./api/api.service";
import { HomeComponent } from './home/home.component';
import { PatientCardComponent } from './patient-card/patient-card.component';
import {DragDropModule} from "@angular/cdk/drag-drop";
import { PatientSchedulerComponent } from './patient-scheduler/patient-scheduler.component';

@NgModule({
    declarations: [
        AppComponent,
        ToolbarComponent,
        HomeComponent,
        PatientCardComponent,
        PatientSchedulerComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatToolbarModule,
        MatButtonModule,
        MatIconModule,
        HttpClientModule,
        DragDropModule,
        // AgmCoreModule.forRoot({apiKey: 'AIzaSyCqHAdLTgi82XNEBtdIDKr7J0FenBq1yCI'})
    ],
    providers: [
        ApiService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
