package domain.rentalrecord.service;

import db.DataStorage;
import domain.rentalrecord.entity.RentalRecord;
import domain.rentalrecord.enums.RentalStatus;
import domain.rentalrecord.requests.CreateRentalRecordRequest;
import domain.user.entity.Customer;
import domain.user.service.IUserService;
import domain.user.service.UserServiceImpl;
import domain.vehicle.entity.Car;
import domain.vehicle.entity.MotorCycle;
import domain.vehicle.entity.Van;
import domain.vehicle.service.IVehicleService;
import domain.vehicle.service.VehicleServiceImpl;
import dto.rentalrecorddto.RentalRecordDto;
import dto.userdto.CustomerDto;
import dto.vehicledto.CarDto;
import dto.vehicledto.MotorCycleDto;
import dto.vehicledto.VanDto;
import dto.vehicledto.VehicleDto;
import exception.AlreadyExistsException;
import exception.ResourceNotFoundException;
import mapper.UserMapper;
import mapper.VehicleMapper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class RentalRecordServiceImpl implements IRentalRecordService{

    private final DataStorage dataStorage = new DataStorage();
    List<RentalRecord> rentalRecordsDb = dataStorage.getListOfRentalRecords();
    private final IVehicleService iVehicleService = new VehicleServiceImpl();
    private final IUserService iUserService = new UserServiceImpl();

    @Override
    public void createRecord(CreateRentalRecordRequest createRentalRecordRequest) {
        RentalRecord rentalRecord = findById(createRentalRecordRequest.getId());
        if (rentalRecord != null)
            throw new AlreadyExistsException("Rental Record", "id", createRentalRecordRequest.getId().toString());

        RentalRecord newRecord = new RentalRecord();

        CustomerDto customerDto = iUserService.getCustomerByEmail(createRentalRecordRequest.getEmail());
        newRecord.setCustomer(UserMapper.mapToCustomer(customerDto, new Customer()));
        VehicleDto vehicleDto = iVehicleService.getVehicleById(createRentalRecordRequest.getVehicleId());

        switch (vehicleDto) {
            case null -> throw new ResourceNotFoundException("Vehicle", "id", createRentalRecordRequest.getId().toString());
            case CarDto carDto -> newRecord.setVehicle(VehicleMapper.mapToCar(carDto, new Car()));
            case VanDto vanDto -> newRecord.setVehicle(VehicleMapper.mapToVan(vanDto, new Van()));
            case MotorCycleDto motorCycleDto -> newRecord.setVehicle(VehicleMapper.mapToMotorcycle(motorCycleDto, new MotorCycle()));
            default -> throw new IllegalStateException("Unexpected value: " + vehicleDto);
        }


        newRecord.setRentalStart(createRentalRecordRequest.getRentalStart());
        newRecord.setRentalFinish(createRentalRecordRequest.getRentalFinish());
        newRecord.setTotalPrice(calculateEstimatedPrice(vehicleDto.getRentalPrice(), createRentalRecordRequest.getRentalStart(), createRentalRecordRequest.getRentalFinish()));
        newRecord.setStatus(RentalStatus.ACTIVE);
        rentalRecordsDb.add(newRecord);
        dataStorage.setListOfRentalRecords(rentalRecordsDb);
    }

    @Override
    public void returnVehicle(Long rentalId) {
        RentalRecord rentalRecord = findById(rentalId);
        if (rentalRecord == null)
            throw new ResourceNotFoundException("Rental Record", "id", rentalId.toString());
        rentalRecord.setStatus(RentalStatus.COMPLETE);
        dataStorage.setListOfRentalRecords(rentalRecordsDb);

    }

    @Override
    public List<RentalRecord> getActiveRentals() {
        return rentalRecordsDb;
    }

    @Override
    public double calculateEstimatedPrice(Long vehicleId, LocalDateTime startDate, LocalDateTime endDate) {
        VehicleDto vehicle = iVehicleService.getVehicleById(vehicleId);
        if (vehicle == null)
            throw new ResourceNotFoundException("Vehicle", "id", vehicleId.toString());
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        return days * vehicle.getRentalPrice();
    }

    @Override
    public double calculateEstimatedPrice(double rentalPrice, LocalDateTime startDate, LocalDateTime endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        return days * rentalPrice;

    }

    private RentalRecord findById (Long id) {
        for (RentalRecord rentalRecord : rentalRecordsDb)
            if (rentalRecord.getId().equals(id)) return rentalRecord;
        return null;
    }


}
