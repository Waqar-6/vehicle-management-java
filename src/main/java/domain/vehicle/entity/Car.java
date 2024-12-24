package domain.vehicle.entity;

public class Car extends Vehicle {

    private int numDoors;
    private String fuelType;

    public Car(Long id, String brand, String model, int year, double rentalPrice, boolean isAvailable, int numDoors, String fuelType) {
        super(id, brand, model, year, rentalPrice, isAvailable);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }


    public int getNumDoors() {return numDoors;}

    public void setNumDoors(int numDoors) {this.numDoors = numDoors;}

    public String getFuelType() {return fuelType;}

    public void setFuelType(String fuelType) {this.fuelType = fuelType;}
}
