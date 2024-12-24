package domain.rentalrecord.controller;

import domain.rentalrecord.entity.RentalRecord;
import domain.rentalrecord.requests.CreateRentalRecordRequest;
import domain.rentalrecord.service.IRentalRecordService;
import domain.rentalrecord.service.RentalRecordServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

public class RentalRecordController {

    private final IRentalRecordService iRentalRecordService = new RentalRecordServiceImpl();

    public void createRecord (CreateRentalRecordRequest createRentalRecordRequest) {
        iRentalRecordService.createRecord(createRentalRecordRequest);
        System.out.println("Record Created");
    }

    public List<RentalRecord> getActiveRecords () {
        return iRentalRecordService.getActiveRentals();
    }

    public double calcPrice (Long vehicleId, LocalDateTime startDate, LocalDateTime endDate) {
        return iRentalRecordService.calculateEstimatedPrice(vehicleId, startDate, endDate);
    }
}
