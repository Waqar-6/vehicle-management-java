package dto.rentalrecorddto;

import domain.rentalrecord.enums.RentalStatus;

import java.time.LocalDateTime;

public class RentalRecordDto {
    private Long id;
    private String fullName;
    private String email;
    private Long vehicleId;
    private LocalDateTime rentalStart;
    private LocalDateTime rentalFinish;
    private RentalStatus status;
    private double totalPrice;

    public RentalRecordDto(Long id, String fullName, String email, Long vehicleId, LocalDateTime rentalStart, LocalDateTime rentalFinish, RentalStatus status, double totalPrice) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.vehicleId = vehicleId;
        this.rentalStart = rentalStart;
        this.rentalFinish = rentalFinish;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public RentalRecordDto () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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
