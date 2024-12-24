package domain.rentalrecord.service;

import domain.rentalrecord.entity.RentalRecord;
import domain.rentalrecord.requests.CreateRentalRecordRequest;
import dto.rentalrecorddto.RentalRecordDto;

import java.time.LocalDateTime;
import java.util.List;

public interface IRentalRecordService {

    void createRecord (CreateRentalRecordRequest createRentalRecordRequest);

    void returnVehicle (Long rentalId);

    List<RentalRecord> getActiveRentals();

    double calculateEstimatedPrice(Long vehicleId, LocalDateTime startDate, LocalDateTime endDate);

    double calculateEstimatedPrice(double rentalPrice, LocalDateTime startDate, LocalDateTime endDate);

}
