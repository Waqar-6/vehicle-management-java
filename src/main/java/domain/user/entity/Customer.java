package domain.user.entity;

import java.time.LocalDateTime;

public class Customer extends User {
    private String drivingLicence;
    private String address;

    public Customer(Long id, String firstName, String lastName, String email, String password, String drivingLicence, String address) {
        super(id, firstName, lastName, email, password);
        this.drivingLicence = drivingLicence;
        this.address = address;
    }

    public Customer () {
        super();
    }



    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
