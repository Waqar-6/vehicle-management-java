package dto;

public class MotorCycleDto extends VehicleDto{

    private String engineSize;
    private boolean isLicenseRequired;

    public MotorCycleDto(Long id, String brand, String model, int year, double rentalPrice, boolean isAvailable, String engineSize, boolean isLicenseRequired) {
        super(id, brand, model, year, rentalPrice, isAvailable);
        this.engineSize = engineSize;
        this.isLicenseRequired = isLicenseRequired;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public boolean isLicenseRequired() {
        return isLicenseRequired;
    }

    public void setLicenseRequired(boolean licenseRequired) {
        isLicenseRequired = licenseRequired;
    }
}
