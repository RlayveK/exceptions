package Model.entities;

import Model.excepetions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;



public class Reservation {
    private Integer roomsNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){

    }

    public Reservation(Integer roomsNumber, Date checkIn, Date checkOut) {
        this.roomsNumber = roomsNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(Integer roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString(){
        return  "Room "
                + getRoomsNumber()
                + ", check-in: "
                + sdf.format(this.checkIn)
                + ", check-out: "
                + sdf.format(this.checkOut)
                + ", "
                + duration()
                + " nights.";
    }
}
