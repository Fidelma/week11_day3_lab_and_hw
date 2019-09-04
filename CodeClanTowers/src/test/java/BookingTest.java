import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Booking booking;
    Bedroom bedroom;
    ConferenceRoom conferenceRoom;
    Guest guest;

    @Before
    public void setUp(){
        bedroom = new Bedroom(11, 2, "double", 150);
        booking = new Booking(bedroom, 2);
        conferenceRoom = new ConferenceRoom("Main", 2);
        guest = new Guest("Frank");
    }

    @Test
    public void hasBedroomWithNumber() {
        assertEquals(11, booking.getRoomNumber());
    }

    @Test
    public void canGetBill() {
        assertEquals(300, booking.getBill());
    }

    @Test
    public void canGetRoom() {
        assertEquals(bedroom, booking.getRoom());
    }
}
