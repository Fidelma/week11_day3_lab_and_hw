import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest;
    Guest guest2;

    @Before
    public void setUP(){
        conferenceRoom = new ConferenceRoom("Main", 8);
        guest = new Guest("Bob");
        guest2 = new Guest("Frank");
    }

    @Test
    public void hasName(){
        assertEquals("Main", conferenceRoom.getName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(8, conferenceRoom.getCapacity());
    }

    @Test
    public void canGetNumberOfGuests() {
        assertEquals(0, conferenceRoom.getNumberOfGuests());
    }

    @Test
    public void canAddGuestToRoom() {
        conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.getNumberOfGuests());
    }

    @Test
    public void canRemoveGuest() {
        conferenceRoom.addGuest(guest);
        conferenceRoom.removeGuest(guest);
        assertEquals(0, conferenceRoom.getNumberOfGuests());
    }

    @Test
    public void cannotRemoveGuestNotInRoom() {
        conferenceRoom.addGuest(guest);
        conferenceRoom.removeGuest(guest2);
        assertEquals(1, conferenceRoom.getNumberOfGuests());
    }
}
