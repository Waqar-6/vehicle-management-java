package dto.vehicledto;

import exception.InvalidDataException;
import exception.Validation;

public class VehicleDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double rentalPrice;
    private boolean isAvailable;

    public VehicleDto(Long id, String brand, String model, int year, double rentalPrice, boolean isAvailable) {

        if (id == null) throw new InvalidDataException("id can not be null");
        if (!Validation.isNotEmpty(brand)) throw new InvalidDataException("Brand can not be empty");
        if (!Validation.isNotEmpty(model)) throw new InvalidDataException("model can not be empty");
        if (!Validation.validDateCheck(year)) throw new InvalidDataException("year can not be in the future");
        if (!Validation.notNegative(rentalPrice)) throw new InvalidDataException("price can not be negative");

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
