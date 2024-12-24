package dto.vehicledto;

import exception.InvalidDataException;
import exception.Validation;

public class CarDto extends VehicleDto {
    private int numDoors;
    private String fuelType;
    public CarDto(Long id, String brand, String model, int year, double rentalPrice, boolean isAvailable, int numDoors, String fuelType) {
        super(id, brand, model, year, rentalPrice, isAvailable);

        if (!Validation.isNotEmpty(fuelType))
            throw new InvalidDataException("fuel type can not be empty");
        if (!Validation.notNegative(numDoors))
            throw new InvalidDataException("number of door can not be negative");


        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    public CarDto () {
        super();
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
