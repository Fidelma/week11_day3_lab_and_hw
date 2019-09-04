import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest;
    Guest guest2;

    @Before
    public void setUp(){
        bedroom = new Bedroom(111, 1, "single", 100);
        guest = new Guest("Bob");
        guest2 = new Guest("Frank");
    }

    @Test
    public void hasRoomNumber(){
        assertEquals(111, bedroom.getRoomNumber());
    }

    @Test
    public void hasCapacity() {
        assertEquals(1, bedroom.getCapacity());
    }

    @Test
    public void hasType() {
        assertEquals("single", bedroom.getType());
    }

    @Test
    public void canGetNumberOfGuests(){
        assertEquals(0, bedroom.getNumberOfGuests());
    }

    @Test
    public void canAddGuest() {
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.getNumberOfGuests());
    }

    @Test
    public void canRemoveGuest() {
        bedroom.addGuest(guest);
        bedroom.removeGuest(guest);
        assertEquals(0, bedroom.getNumberOfGuests());
    }

    @Test
    public void cannotRemoveGuestNotInRoom() {
        bedroom.addGuest(guest);
        bedroom.removeGuest(guest2);
        assertEquals(1, bedroom.getNumberOfGuests());
    }

    @Test
    public void canGetRate() {
        assertEquals(100, bedroom.getRate());
    }
}
