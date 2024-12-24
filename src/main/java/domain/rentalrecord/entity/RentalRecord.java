package domain.rentalrecord.entity;

import domain.rentalrecord.enums.RentalStatus;
import domain.user.entity.Customer;
import domain.vehicle.entity.Vehicle;

import java.time.LocalDateTime;

public class RentalRecord {
    private Long id;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDateTime rentalStart;
    private LocalDateTime rentalFinish;
    private RentalStatus status;
    private double totalPrice;

    public RentalRecord(Long id, Customer customer, Vehicle vehicle, LocalDateTime rentalStart, LocalDateTime rentalFinish, RentalStatus status, double totalPrice) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalStart = rentalStart;
        this.rentalFinish = rentalFinish;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public RentalRecord () {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(LocalDateTime rentalStart) {
        this.rentalStart = rentalStart;
    }

    public LocalDateTime getRentalFinish() {
        return rentalFinish;
    }

    public void setRentalFinish(LocalDateTime rentalFinish) {
        this.rentalFinish = rentalFinish;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
