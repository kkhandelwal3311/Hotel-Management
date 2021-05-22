export interface Booking {
  hotelId: {
    hotelId: number;
  };
  roomId: {
    roomId: number;
  };
  userId: {
    userId: number;
  };
  bookedFrom: string;
  bookedTo: string;
  noOfAdults: number;
  noOfChildren: number;
  amount: number;
}
