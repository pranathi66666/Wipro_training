import java.util.*;

// Base Room Class
class Room {
    protected int roomNumber;
    protected boolean isBooked;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    public boolean isAvailable() {
        return !isBooked;
    }

    public void bookRoom() {
        if (isAvailable()) {
            isBooked = true;
            System.out.println("Room " + roomNumber + " has been booked.");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    public void checkOutRoom() {
        if (isBooked) {
            isBooked = false;
            System.out.println("Room " + roomNumber + " has been checked out.");
        } else {
            System.out.println("Room " + roomNumber + " is already available.");
        }
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return "Standard Room";
    }
}

// Deluxe Room Class (Inheritance)
class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public String getRoomType() {
        return "Deluxe Room";
    }
}

// Customer Class
class Customer {
    private String name;
    private String contactInfo;

    public Customer(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}

// Booking Class
class Booking {
    private Room room;
    private Customer customer;
    private Date bookingDate;

    public Booking(Room room, Customer customer) {
        this.room = room;
        this.customer = customer;
        this.bookingDate = new Date(); // Booking date set to current date
        room.bookRoom();
    }

    public void cancelBooking() {
        room.checkOutRoom();
        System.out.println("Booking for customer " + customer.getName() + " has been cancelled.");
    }

    public void displayBookingDetails() {
        System.out.println("Booking Details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Contact Info: " + customer.getContactInfo());
        System.out.println("Room Number: " + room.getRoomNumber());
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Booking Date: " + bookingDate);
    }
}

// Hotel Management System
class HotelManagement {
    private List<Room> rooms;
    private List<Booking> bookings;

    public HotelManagement() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 1; i <= 10; i++) {
            rooms.add(new Room(i)); // Standard Rooms
        }
        for (int i = 11; i <= 15; i++) {
            rooms.add(new DeluxeRoom(i)); // Deluxe Rooms
        }
    }

    public void checkRoomAvailability() {
        System.out.println("Room Availability:");
        for (Room room : rooms) {
            System.out.println("Room " + room.getRoomNumber() + " (" + room.getRoomType() + "): " + (room.isAvailable() ? "Available" : "Booked"));
        }
    }

    public void bookRoom(int roomNumber, Customer customer) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null && room.isAvailable()) {
            Booking booking = new Booking(room, customer);
            bookings.add(booking);
            System.out.println("Room " + roomNumber + " successfully booked for " + customer.getName() + ".");
        } else {
            System.out.println("Room " + roomNumber + " is not available for booking.");
        }
    }

    public void checkOutRoom(int roomNumber) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null && !room.isAvailable()) {
            room.checkOutRoom();
        } else {
            System.out.println("Room " + roomNumber + " is already available.");
        }
    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        System.out.println("Room " + roomNumber + " does not exist.");
        return null;
    }
}

// Main Class
public class HotelRoomBookingSystem {
    public static void main(String[] args) {
        HotelManagement hotel = new HotelManagement();

        // Display available rooms
        hotel.checkRoomAvailability();

        // Create customers
        Customer customer1 = new Customer("Alice", "alice@example.com");
        Customer customer2 = new Customer("Bob", "bob@example.com");

        // Book rooms
        hotel.bookRoom(3, customer1);
        hotel.bookRoom(12, customer2);

        // Check room availability again
        hotel.checkRoomAvailability();

        // Check out a room
        hotel.checkOutRoom(3);

        // Check room availability after check-out
        hotel.checkRoomAvailability();
    }
}
