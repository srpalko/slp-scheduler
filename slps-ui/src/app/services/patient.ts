import {Therapist} from "./therapist";

export interface Patient {
    id: number;
    firstName: string;
    lastName: string;
    dateOfBirth: any;
    ssn: string;
    startOfCare: any;
    status: string;
    therapist: Therapist;
    address: {
        streetAddress: string;
        city: string;
        state: string;
        zip: string;
    }
    location: any;
}
