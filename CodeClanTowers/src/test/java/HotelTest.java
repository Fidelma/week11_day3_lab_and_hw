import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    ConferenceRoom conferenceRoom1;
    ConferenceRoom conferenceRoom2;
    ConferenceRoom conferenceRoom3;
    Guest guest1;
    Guest guest2;
    ArrayList<Bedroom> emptyBedrooms;

    @Before
    public void setUp(){
        hotel = new Hotel();
        bedroom1 = new Bedroom(11, 2, "double", 200);
        bedroom2 = new Bedroom(14, 1, "single", 50);
        bedroom3 = new Bedroom(111, 3, "family", 250);
        conferenceRoom1 = new ConferenceRoom("Old White Men", 2);
        conferenceRoom2 = new ConferenceRoom("Main", 8);
        conferenceRoom3 = new ConferenceRoom("Hip and Cool", 3);
        guest1 = new Guest("Freddy");
        guest2 = new Guest("Ben");

        hotel.addBedroom(bedroom1);
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.addConferenceRoom(conferenceRoom1);
        hotel.addConferenceRoom(conferenceRoom2);
        hotel.addConferenceRoom(conferenceRoom3);
    }

//    @Test
//    public void hasNoBedroomsToStart(){
//        assertEquals(0, hotel.getNumberOfBedrooms());
//    }

    @Test
    public void canAddBedroom() {
        hotel.addBedroom(bedroom1);
        assertEquals(4, hotel.getNumberOfBedrooms());
    }

    @Test
    public void canGetNumberOfConferenceRooms() {
        assertEquals(3, hotel.getNumberOfConferenceRooms());
    }

    @Test
    public void canAddConferenceRoom() {
        hotel.addConferenceRoom(conferenceRoom1);
        assertEquals(4, hotel.getNumberOfConferenceRooms());
    }

    @Test
    public void canCheckGuestIntoRoom() {
        hotel.checkGuestIntoBedroom(bedroom1, guest1);
        assertEquals(1, bedroom1.getNumberOfGuests());
    }

    @Test
    public void canCheckGuestIntoConferenceRoom() {
        hotel.checkGuestIntoConferenceRoom(conferenceRoom1, guest2);
        assertEquals(1, conferenceRoom1.getNumberOfGuests());
    }

    @Test
    public void canCheckGuestOutOfBedroom() {
        hotel.checkGuestIntoBedroom(bedroom1, guest1);
        hotel.checkGuestIntoBedroom(bedroom1, guest2);
        hotel.checkGuestOutOfBedroom(bedroom1, guest1);
        assertEquals(1, bedroom1.getNumberOfGuests());
    }

    @Test
    public void cannotCheckGuestOutOfBedroomIfN0tIn() {
        hotel.checkGuestIntoBedroom(bedroom1, guest1);
        hotel.checkGuestOutOfBedroom(bedroom1, guest2);
        assertEquals(1, bedroom1.getNumberOfGuests());
    }

    @Test
    public void canCheckGuestOutOfConferenceRoom() {
        hotel.checkGuestIntoConferenceRoom(conferenceRoom1, guest2);
        hotel.checkGuestIntoConferenceRoom(conferenceRoom1, guest1);
        hotel.checkGuestOutOfConferenceRoom(conferenceRoom1, guest1);
        assertEquals(1, conferenceRoom1.getNumberOfGuests());
    }

    @Test
    public void canCreateBooking() {
        hotel.bookRoom(bedroom1, 2);
        assertEquals(1, hotel.getBookings());
    }

    @Test
    public void getBillWhenBookRoom() {
        assertEquals(400, hotel.bookRoom(bedroom1, 2));
    }

    @Test
    public void hasCollectionOfEmptyBedrooms() {
        hotel.bookRoom(bedroom1, 2);
        hotel.bookRoom(bedroom2, 1);
        assertEquals(1, hotel.numberOfEmptyRooms());
    }

    @Test
    public void cannotCheckGuestIntoBookedRoom() {
        hotel.bookRoom(bedroom1, 2);
        hotel.checkGuestIntoBedroom(bedroom1, guest1);
        hotel.checkGuestIntoBedroom(bedroom3, guest1);
        assertEquals(0, bedroom1.getNumberOfGuests());
        assertEquals(1, bedroom3.getNumberOfGuests());

    }
}
