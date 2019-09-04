import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Booking> bookings;
    private ArrayList<Bedroom> emptyBedrooms;

    public Hotel(){
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.bookings = new ArrayList<Booking>();
        this.emptyBedrooms = new ArrayList<Bedroom>();

    }

    public int getNumberOfBedrooms() {
        return bedrooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
        this.emptyBedrooms.add(bedroom);
    }

    public int getNumberOfConferenceRooms() {
        return conferenceRooms.size();
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRooms.add(conferenceRoom);
    }

    public void checkGuestIntoBedroom(Bedroom bedroom, Guest guest) {
        if (emptyBedrooms.contains(bedroom)){
            bedroom.addGuest(guest);
        }
    }

    public void checkGuestIntoConferenceRoom(ConferenceRoom conferenceRoom, Guest guest) {
        conferenceRoom.addGuest(guest);
    }

    public void checkGuestOutOfBedroom(Bedroom bedroom, Guest guest) {
        bedroom.removeGuest(guest);
    }

    public void checkGuestOutOfConferenceRoom(ConferenceRoom conferenceRoom, Guest guest) {
        conferenceRoom.removeGuest(guest);
    }

    public int getBookings() {
        return bookings.size();
    }

    public int bookRoom(Bedroom bedroom, int nights) {
        Booking booking = new Booking(bedroom, nights);
        bookings.add(booking);
        emptyBedrooms.remove(bedroom);
        return booking.getBill();
    }

    public int numberOfEmptyRooms() {
       return emptyBedrooms.size();
    }

}
