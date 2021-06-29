import {Patient} from "../services/patient";

export interface Schedule {
    monday: Patient[]
    tuesday: Patient[]
    wednesday: Patient[]
    thursday: Patient[]
    friday: Patient[]
}
