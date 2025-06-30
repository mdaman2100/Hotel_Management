# Hotel Management System

## Overview

The Hotel Management System is a simple Java-based application that allows users to manage hotel room reservations. It provides functionality to view available rooms, make reservations, and view details of existing reservations.

## Features

- **View Available Rooms**: Displays all available rooms with their details (room number, type, rate, and availability).
- **Make a Reservation**: Allows users to book a room for a specified number of nights.
- **View Reservation Details**: Displays the details of a specific reservation by entering the reservation ID.

## Classes

### `Reservation`
Represents a booking made by a guest.

- **Fields:**
  - `reservationId`: Unique identifier for the reservation.
  - `guestName`: Name of the guest.
  - `bookedRoom`: Room details for the reservation.
  - `stayDuration`: Number of nights the room is booked for.

- **Methods:**
  - `getReservationId()`: Returns the reservation ID.
  - `getGuestName()`: Returns the name of the guest.
  - `getBookedRoom()`: Returns the booked room details.
  - `getStayDuration()`: Returns the duration of the stay.
  - `toString()`: Returns a string representation of the reservation.

### `Room`
Represents a hotel room.

- **Fields:**
  - `roomNumber`: Room number.
  - `roomType`: Type of the room (e.g., Single, Double, Suite).
  - `roomRate`: Cost per night for the room.
  - `isAvailable`: Availability status of the room.

- **Methods:**
  - `getRoomNumber()`: Returns the room number.
  - `getRoomType()`: Returns the room type.
  - `getRoomRate()`: Returns the cost per night.
  - `isAvailable()`: Returns the availability status.
  - `setAvailability()`: Sets the availability status.
  - `toString()`: Returns a string representation of the room.

### `PaymentProcessor`
Handles payment processing for reservations.

- **Methods:**
  - `processPayment(guestName, totalAmount)`: Processes the payment for the specified guest and amount. Returns `true` if the payment is successful.

### `HotelService`
Manages hotel operations such as room availability and reservations.

- **Fields:**
  - `rooms`: List of all rooms in the hotel.
  - `reservations`: Map of all reservations with their ID as the key.

- **Methods:**
  - `showAvailableRooms()`: Displays all available rooms.
  - `createReservation(guestName, roomNumber, stayDuration)`: Creates a reservation for a guest in the specified room.
  - `showReservation(reservationId)`: Displays the details of a reservation by its ID.
  - `findAvailableRoom(roomNumber)`: Finds an available room by its number.


##EXAMPLE
1. View Available Rooms
2. Make a Reservation
3. View Reservation Details
4. Exit
Please select an option: 2
Enter the guest name: JohnDoe
Enter the room number: 102
Enter the number of nights: 3
Processing payment for JohnDoe of $450.0
Reservation confirmed: Reservation{Reservation ID=1, Guest Name='JohnDoe', Room Details=Room{Room Number=102, Type='Double', Rate=150.0, Available=false}, Stay Duration (nights)=3}

   
   

