import java.util.Scanner;

class Room{

    int roomNumber;
    String type;
    boolean booked;

    Room(int roomNumber,String type, boolean booked){

        this.roomNumber = roomNumber;
        this.type = type;
        this.booked = false;
    }
}

class Hotel{

    Room[] rooms = new Room[90];

    Hotel(){

        int index = 0;

        // Standard Rooms
        for(int i = 101; i <= 130; i++){

            rooms[index++] = new Room(i,"Standard",false);
        }

        // Deluxe Rooms
        for(int i = 201; i <= 230; i++){

            rooms[index++] = new Room(i,"Deluxe",false);
        }

        // Suite Rooms
        for(int i = 301; i <= 330; i++){

            rooms[index++] = new Room(i,"Suite",false);
        }

        // Pre-booking some rooms for real hotel experience
        rooms[0].booked = true;   // 101
        rooms[35].booked = true;  // 206
        rooms[70].booked = true;  // 311
    }

    // Display Available Rooms
    void displayRooms(String type){

        System.out.println("\nAvailable " + type + " Rooms:");

        boolean available = false;

        for(Room r : rooms){

            if(r.type.equals(type) && !r.booked){

                System.out.print(r.roomNumber + " ");

                available = true;
            }
        }

        if(!available){

            System.out.println("No rooms available");
        }

        System.out.println();
    }

    // Book Room
    void bookRoom(int roomNumber){

        Scanner sc = new Scanner(System.in);

        for(Room r : rooms){

            if(r.roomNumber == roomNumber){

                if(r.booked){

                    System.out.println("Room already booked!");
                }
                else{
                    if(roomNumber>100 && roomNumber<200)
                        System.out.println("Room Price : Rs.1200");
                    else if(roomNumber>200 && roomNumber<300)
                        System.out.println("Room Price : Rs.2500");
                    else
                        System.out.println("Room Price : Rs.4000");

                    System.out.println("1. Pay Now");
                    System.out.println("2. Cancel");

                    int paymentChoice = sc.nextInt();

                    if(paymentChoice == 1){

                        r.booked = true;

                        System.out.println("\nPayment Successful!");

                        System.out.println("Room Booked Successfully!");

                        System.out.println("Room Number : " + r.roomNumber);

                        System.out.println("Room Type : " + r.type);
                    }
                    else{

                        System.out.println("Booking Cancelled!");
                    }
                }

                return;
            }
        }

        System.out.println("Invalid Room Number!");
    }

    // Cancel Reservation
    void cancelRoom(int roomNumber){

        for(Room r : rooms){

            if(r.roomNumber == roomNumber){

                if(r.booked){

                    r.booked = false;


                    System.out.println("Reservation Cancelled!");
                    System.out.println("90% of your money will be returned by tomorrow!");
                }
                else{

                    System.out.println("Room is already available!");
                }

                return;
            }
        }

        System.out.println("Invalid Room Number!");
    }
}

public class Task2_CodeAlpha{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        int choice;

        do{

            System.out.println("\n========== HOTEL RESERVATION SYSTEM ==========");

            System.out.println("1. Display Standard Rooms");
            System.out.println("2. Display Deluxe Rooms");
            System.out.println("3. Display Suite Rooms");

            System.out.println("4. Book Room");

            System.out.println("5. Cancel Reservation");

            System.out.println("-1. Exit");

            System.out.print("\nEnter Choice : ");

            choice = sc.nextInt();

            switch(choice){

                case 1:

                    hotel.displayRooms("Standard");

                    break;

                case 2:

                    hotel.displayRooms("Deluxe");

                    break;

                case 3:

                    hotel.displayRooms("Suite");

                    break;

                case 4:

                    System.out.print("Enter Room Number to Book : ");

                    int bookRoom = sc.nextInt();

                    hotel.bookRoom(bookRoom);

                    break;

                case 5:

                    System.out.print("Enter Room Number to Cancel : ");

                    int cancelRoom = sc.nextInt();

                    hotel.cancelRoom(cancelRoom);

                    break;

                case -1:

                    System.out.println("Thank You for Visiting!\nPlease visit us again");

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        }while(choice != -1);

        sc.close();
    }
}