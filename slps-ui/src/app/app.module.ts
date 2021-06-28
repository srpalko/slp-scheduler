import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {ToolbarComponent} from './toolbar/toolbar.component';
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from './home/home.component';
import {PatientCardComponent} from './patient-card/patient-card.component';
import {DragDropModule} from "@angular/cdk/drag-drop";
import {PatientSchedulerComponent} from './patient-scheduler/patient-scheduler.component';
import {MatTableModule} from "@angular/material/table";
import {StatsComponent} from './stats/stats.component';
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {MatCardModule} from "@angular/material/card";

@NgModule({
    declarations: [
        AppComponent,
        ToolbarComponent,
        HomeComponent,
        PatientCardComponent,
        PatientSchedulerComponent,
        StatsComponent,
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
        MatTableModule,
        FormsModule,
        LayoutModule,
        MatCardModule,
        // AgmCoreModule.forRoot({apiKey: 'AIzaSyCqHAdLTgi82XNEBtdIDKr7J0FenBq1yCI'})
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
