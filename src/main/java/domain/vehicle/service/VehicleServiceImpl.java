package domain.vehicle.service;

import db.DataStorage;
import domain.vehicle.VehicleFactory;
import domain.vehicle.entity.Car;
import domain.vehicle.entity.MotorCycle;
import domain.vehicle.entity.Van;
import domain.vehicle.entity.Vehicle;
import dto.vehicledto.CarDto;
import dto.vehicledto.MotorCycleDto;
import dto.vehicledto.VanDto;
import dto.vehicledto.VehicleDto;
import exception.AlreadyExistsException;
import exception.ResourceNotFoundException;
import mapper.VehicleMapper;

import java.util.List;

public class VehicleServiceImpl implements IVehicleService{

    DataStorage dataStorage = new DataStorage();
    List<Vehicle> vehicleDb = dataStorage.getListOfVehicles();

    @Override
    public <T extends VehicleDto> void createVehicle(String type, T data) {
        Vehicle vehicle = findById(data.getId());
        if (vehicle != null)
            throw new AlreadyExistsException("Vehicle", "Id", data.getId().toString());
        Vehicle newVehicle = VehicleFactory.createVehicle(type, data);
        vehicleDb.add(newVehicle);
        dataStorage.setListOfVehicles(vehicleDb);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicleDb.stream().map(vehicle -> {
            return switch (vehicle) {
                case Car car -> VehicleMapper.mapToCarDto(car, new CarDto());
                case MotorCycle motorCycle -> VehicleMapper.mapToMotorcycleDto(motorCycle, new MotorCycleDto());
                case Van van -> VehicleMapper.mapToVanDto(van, new VanDto());
                default -> VehicleMapper.mapToVehicleDto(vehicle, new VehicleDto());
            };
        }).toList();
    }

    @Override
    public VehicleDto getVehicleById(Long id) {
        Vehicle vehicle = findById(id);
        return switch (vehicle) {
            case null -> throw new ResourceNotFoundException("Vehicle", "id", id.toString());
            case Car car -> VehicleMapper.mapToCarDto(car, new CarDto());
            case MotorCycle motorCycle -> VehicleMapper.mapToMotorcycleDto(motorCycle, new MotorCycleDto());
            case Van van -> VehicleMapper.mapToVanDto(van, new VanDto());
            default -> null;
        };
    }

    @Override
    public List<VehicleDto> getAvailableVehicles() {
        return vehicleDb.stream().filter(Vehicle::isAvailable)
                .map(vehicle -> {
                    return switch (vehicle) {
                        case Car car -> VehicleMapper.mapToCarDto(car, new CarDto());
                        case MotorCycle motorCycle -> VehicleMapper.mapToMotorcycleDto(motorCycle, new MotorCycleDto());
                        case Van van -> VehicleMapper.mapToVanDto(van, new VanDto());
                        default -> VehicleMapper.mapToVehicleDto(vehicle, new VehicleDto());
                    };
                }).toList();
    }

    @Override
    public <T extends VehicleDto> void updateVehicle(Long id, T vehicleDto) {

        Vehicle vehicle = findById(id);
        if (vehicle == null) throw new ResourceNotFoundException("Vehicle", "id", id.toString());

        if (vehicleDto instanceof CarDto carDto && vehicle instanceof Car car)
            VehicleMapper.mapToCar(carDto, car);
        if (vehicleDto instanceof MotorCycleDto motorCycleDto && vehicle instanceof MotorCycle motorCycle)
            VehicleMapper.mapToMotorcycle(motorCycleDto, motorCycle);
        if (vehicleDto instanceof VanDto vanDto && vehicle instanceof Van van)
            VehicleMapper.mapToVan(vanDto, van);


//        switch (vehicleDto) {
//            case CarDto carDto -> VehicleMapper.mapToCar(carDto,(Car) vehicle);
//            case MotorCycleDto motorCycleDto -> VehicleMapper.mapToMotorcycle(motorCycleDto,(MotorCycle) vehicle);
//            case VanDto vanDto -> VehicleMapper.mapToVan(vanDto, (Van) vehicle);
//            default -> throw new IllegalStateException("Unexpected value: " + vehicleDto);
//        }

        dataStorage.setListOfVehicles(vehicleDb);
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicleTODelete = findById(id);
        if (vehicleTODelete == null) throw new ResourceNotFoundException("Vehicle", "id", id.toString());
        vehicleDb.remove(vehicleTODelete);
        dataStorage.setListOfVehicles(vehicleDb);
    }

    @Override
    public void updateVehicleAvailability(Long id, boolean isAvailable) {
        Vehicle vehicle = findById(id);
        if (vehicle == null) throw new ResourceNotFoundException("Vehicle", "id", id.toString());
        vehicle.setAvailable(isAvailable);
        dataStorage.setListOfVehicles(vehicleDb);

    }

    private Vehicle findById (Long id) {
        for (Vehicle vehicle : vehicleDb) if (vehicle.getId().equals(id)) return vehicle;
        return null;
    }
}
