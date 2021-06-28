import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class MapService {

    data: any;
    findMatrix(origin: string[], destination: string[]): any {
        // @ts-ignore
        const service = new google.maps.DistanceMatrixService();
        const matrixOptions = {
            origins: origin,
            destinations: destination,
            travelMode: 'DRIVING',
            unitSystem: google.maps.UnitSystem.IMPERIAL
        };
        // @ts-ignore
        service.getDistanceMatrix(matrixOptions, callback);

        function callback(response: any, status: string) {
            if (status !== "OK") {
                alert("Error with distance matrix");
                return;
            }
            console.log(response);
        }
    }
}
