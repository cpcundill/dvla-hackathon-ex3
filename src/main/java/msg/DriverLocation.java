package msg;

import msg.postcode.service.Coord;

public class DriverLocation {

    private Driver driver;
    private Coord coordinates;

    public DriverLocation() {}

    public DriverLocation(Driver driver) {
        this.driver = driver;
    }

    public DriverLocation(Driver driver, Coord coordinates) {
        this.driver = driver;
        this.coordinates = coordinates;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Coord getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coord coordinates) {
        this.coordinates = coordinates;
    }
}
