public class Booking {

    private Bedroom bedroom;
    private int nights;

    public Booking(Bedroom bedroom, int nights){
        this.bedroom = bedroom;
        this.nights = nights;
    }

    public int getRoomNumber() {
        return this.bedroom.getRoomNumber();
    }

    public int getBill() {
        return bedroom.getRate() * nights;
    }

    public Bedroom getRoom() {
        return bedroom;
    }
}
