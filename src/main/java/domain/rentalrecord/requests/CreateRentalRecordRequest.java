package domain.rentalrecord.requests;

import java.time.LocalDateTime;

public class CreateRentalRecordRequest {
    private Long id;
    private String email;
    private Long vehicleId;
    private LocalDateTime rentalStart;
    private LocalDateTime rentalFinish;

    public CreateRentalRecordRequest(Long id, String email, Long vehicleId, LocalDateTime rentalStart, LocalDateTime rentalFinish) {
        this.id = id;
        this.email = email;
        this.vehicleId = vehicleId;
        this.rentalStart = rentalStart;
        this.rentalFinish = rentalFinish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}