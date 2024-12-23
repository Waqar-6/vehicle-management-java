package domain.vehicle;

public abstract class Vehicle {

    private Long id;
    private String brand;
    private String model;
    private int year;
    private double rentalPrice;
    private boolean isAvailable;

    public Vehicle(Long id, String brand, String model, int year, double rentalPrice, boolean isAvailable) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
        this.isAvailable = isAvailable;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}

    public double getRentalPrice() {return rentalPrice;}

    public void setRentalPrice(double rentalPrice) {this.rentalPrice = rentalPrice;}

    public boolean isAvailable() {return isAvailable;}

    public void setAvailable(boolean available) {isAvailable = available;}

    public String getVehicleInfo () {
        return String.format("classes.Vehicle ID: %s, Brand: %s, Model: %s, Year: %s, Rental price: %s and Available: %s",
                this.id, this.brand, this.model, this.year, this.rentalPrice, this.isAvailable);
    }

}
