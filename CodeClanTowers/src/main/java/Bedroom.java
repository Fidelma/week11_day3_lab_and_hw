import java.util.ArrayList;

public class Bedroom {

    private int roomNumber;
    private int capacity;
    private String type;
    private int rate;
    private ArrayList<Guest> guests;

    public Bedroom(int roomNumber, int capacity, String type, int rate){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.type = type;
        this.rate = rate;
        this.guests = new ArrayList<Guest>();

    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public int getNumberOfGuests() {
        return guests.size();
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void removeGuest(Guest guest) {
        if (this.guests.contains(guest)) {
            this.guests.remove(guest);
        }
    }

    public int getRate() {
        return rate;
    }
}
