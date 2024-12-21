package dto;

import exception.InvalidDataException;
import exception.Validation;

public class MotorCycleDto extends VehicleDto{

    private String engineSize;
    private boolean isLicenseRequired;

    public MotorCycleDto(Long id, String brand, String model, int year, double rentalPrice, boolean isAvailable, String engineSize, boolean isLicenseRequired) {
        super(id, brand, model, year, rentalPrice, isAvailable);

        if (!Validation.isNotEmpty(engineSize))
            throw new InvalidDataException("engine size can not be empty");

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
