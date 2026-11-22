
import java.util.ArrayList;

// Class 1: Room
class Room {
    int roomNumber;
    String roomType;
    double price;
    boolean isAvailable;

    Room(int roomNumber, String roomType, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    void displayRoom() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price: " + price);
        System.out.println("Available: " + isAvailable);
        System.out.println("--------------------");
    }
}

// Class 2: Hotel
class Hotel {

    ArrayList<Room> rooms = new ArrayList<>();

    // Add room
    void addRoom(Room r) {
        rooms.add(r);
        System.out.println("Room added successfully!");
    }

    // Display all rooms using recursion
    void displayRooms(int index) {
        if (index >= rooms.size()) {
            return;
        }

        rooms.get(index).displayRoom();
        displayRooms(index + 1);
    }

    // Search room using recursion
    Room searchRoom(int roomNumber, int index) {
        if (index >= rooms.size()) {
            return null;
        }

        if (rooms.get(index).roomNumber == roomNumber) {
            return rooms.get(index);
        }

        return searchRoom(roomNumber, index + 1);
    }

    // Book room
    void bookRoom(int roomNumber) {
        Room r = searchRoom(roomNumber, 0);

        if (r == null) {
            System.out.println("Room not found!");
        }
        else if (!r.isAvailable) {
            System.out.println("Room is already booked!");
        }
        else {
            r.isAvailable = false;
            System.out.println("Room booked successfully!");
        }
    }

    // Checkout room
    void checkoutRoom(int roomNumber) {
        Room r = searchRoom(roomNumber, 0);

        if (r == null) {
            System.out.println("Room not found!");
        }
        else if (r.isAvailable) {
            System.out.println("Room is already available!");
        }
        else {
            r.isAvailable = true;
            System.out.println("Checkout successful!");
        }
    }

    // Display available rooms using recursion
    void displayAvailableRooms(int index) {
        if (index >= rooms.size()) {
            return;
        }

        Room r = rooms.get(index);

        if (r.isAvailable) {
            r.displayRoom();
        }

        displayAvailableRooms(index + 1);
    }
}

// Class 3: Main
public class hotels{
    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        // Creating Room objects
        Room r1 = new Room(101, "Deluxe", 2500, true);
        Room r2 = new Room(102, "Standard", 1500, true);
        Room r3 = new Room(103, "Luxury", 4000, true);
        Room r4 = new Room(104, "Standard", 1500, true);

        // Adding rooms
        hotel.addRoom(r1);
        hotel.addRoom(r2);
        hotel.addRoom(r3);
        hotel.addRoom(r4);

        System.out.println("\nALL ROOMS:");
        hotel.displayRooms(0);

        // Booking a room
        System.out.println("\nBOOKING ROOM 102:");
        hotel.bookRoom(102);

        // Display available rooms
        System.out.println("\nAVAILABLE ROOMS:");
        hotel.displayAvailableRooms(0);

        // Checkout
        System.out.println("\nCHECKOUT ROOM 102:");
        hotel.checkoutRoom(102);

        // Final room list
        System.out.println("\nUPDATED ROOM LIST:");
        hotel.displayRooms(0);
    }
}
