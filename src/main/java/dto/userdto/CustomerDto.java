package dto.userdto;

public class CustomerDto extends UserDto{

    private String drivingLicence;
    private String address;

    public CustomerDto(Long id, String firstName, String lastName, String email, String drivingLicence, String address) {
        super(id, firstName, lastName, email);
        this.drivingLicence = drivingLicence;
        this.address = address;
    }

    public CustomerDto () {}

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
