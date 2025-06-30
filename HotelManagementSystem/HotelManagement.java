import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

class Reservation {
    private static int idCounter = 1;
    private int reservationId;
    private String guestName;
    private Room bookedRoom;
    private int stayDuration;

    public Reservation(String guestName, Room bookedRoom, int stayDuration) {
        this.reservationId = idCounter++;
        this.guestName = guestName;
        this.bookedRoom = bookedRoom;
        this.stayDuration = stayDuration;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public int getStayDuration() {
        return stayDuration;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "Reservation ID=" + reservationId +
                ", Guest Name='" + guestName + '\'' +
                ", Room Details=" + bookedRoom +
                ", Stay Duration (nights)=" + stayDuration +
                '}';
    }
}

class Room {
    private int roomNumber;
    private String roomType;
    private double roomRate;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double roomRate) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomRate = roomRate;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomRate() {
        return roomRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Room Number=" + roomNumber +
                ", Type='" + roomType + '\'' +
                ", Rate=" + roomRate +
                ", Available=" + isAvailable +
                '}';
    }
}

class PaymentProcessor {
    public static boolean processPayment(String guestName, double totalAmount) {
        System.out.println("Processing payment for " + guestName + " of $" + totalAmount);
        return true;
    }
}

class HotelService {
    private ArrayList<Room> rooms;
    private HashMap<Integer, Reservation> reservations;

    public HotelService() {
        rooms = new ArrayList<>();
        reservations = new HashMap<>();
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Double", 150.0));
        rooms.add(new Room(103, "Suite", 250.0));
    }

    public void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public void createReservation(String guestName, int roomNumber, int stayDuration) {
        Room room = findAvailableRoom(roomNumber);
        if (room == null) {
            System.out.println("Sorry, Room " + roomNumber + " is not available.");
            return;
        }

        double totalCost = room.getRoomRate() * stayDuration;
        if (PaymentProcessor.processPayment(guestName, totalCost)) {
            room.setAvailability(false);
            Reservation reservation = new Reservation(guestName, room, stayDuration);
            reservations.put(reservation.getReservationId(), reservation);
            System.out.println("Reservation confirmed: " + reservation);
        } else {
            System.out.println("Payment failed. Unable to complete the reservation.");
        }
    }

    public void showReservation(int reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null) {
            System.out.println("Reservation Details:");
            System.out.println(reservation);
        } else {
            System.out.println("No reservation found with ID " + reservationId);
        }
    }

    public Room findAvailableRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                return room;
            }
        }
        return null;
    }
}

public class HotelManagement{
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservation Details");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    hotelService.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter the guest name: ");
                    String guestName = scanner.next();
                    System.out.print("Enter the room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter the number of nights: ");
                    int stayDuration = scanner.nextInt();
                    hotelService.createReservation(guestName, roomNumber, stayDuration);
                    break;
                case 3:
                    System.out.print("Enter reservation ID: ");
                    int reservationId = scanner.nextInt();
                    hotelService.showReservation(reservationId);
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
