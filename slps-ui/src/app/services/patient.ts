import {Therapist} from "./therapist";

export class Patient {
    constructor(
      public  id: number,
    public firstName: string,
    public lastName: string,
    public dateOfBirth: any,
    public ssn: string,
    public startOfCare: any,
    public status: string,
    public therapist: Therapist,
    public address: {
        streetAddress: string;
        city: string;
        state: string;
        zip: string;
    },
    public location: any,
      public testX: number = 0,
      public testY: number = 0,
      public distance: number = 0
    ) {
    }

}
