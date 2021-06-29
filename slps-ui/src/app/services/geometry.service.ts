import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GeometryService {
  findDistance(originX: number, originY: number, destX: number, destY: number): number {
    return Math.sqrt((Math.pow(destX - originX, 2)) + (Math.pow(destY - originY, 2)));
  }
}

