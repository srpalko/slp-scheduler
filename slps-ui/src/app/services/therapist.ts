export interface Therapist {
    id: number;
    appointmentList: any[];
    patients: any[];
    homeLocation: string;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    email: string;
    address: {
        streetAddress: string;
        city: string;
        state: string;
        zip: string;
    }
}

