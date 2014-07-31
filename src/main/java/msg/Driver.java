package msg;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Driver {

    private String currentDriverNumber;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="UTC")
    private Date dob;
    private Address address;

    public Driver() {}

    public Driver(msg.postcode.service.Driver driver, Date dob) {
        this.currentDriverNumber = driver.getCurrentDriverNumber();
        this.address = driver.getAddress();
        this.dob = dob;
    }

    public String getCurrentDriverNumber() {
        return currentDriverNumber;
    }

    public void setCurrentDriverNumber(String currentDriverNumber) {
        this.currentDriverNumber = currentDriverNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
