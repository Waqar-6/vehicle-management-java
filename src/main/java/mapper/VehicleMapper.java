package mapper;

import domain.vehicle.entity.Car;
import domain.vehicle.entity.MotorCycle;
import domain.vehicle.entity.Van;
import domain.vehicle.entity.Vehicle;
import dto.vehicledto.CarDto;
import dto.vehicledto.MotorCycleDto;
import dto.vehicledto.VanDto;
import dto.vehicledto.VehicleDto;

public final class VehicleMapper {

    private VehicleMapper () {}
    // Entity to DTO
    public static VehicleDto mapToVehicleDto(Vehicle vehicle, VehicleDto vehicleDto) {
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setYear(vehicle.getYear());
        vehicleDto.setRentalPrice(vehicle.getRentalPrice());
        vehicleDto.setAvailable(vehicle.isAvailable());
        return vehicleDto;
    }

    public static CarDto mapToCarDto(Car car, CarDto carDto) {
        mapToVehicleDto(car, carDto);
        carDto.setNumDoors(car.getNumDoors());
        carDto.setFuelType(car.getFuelType());
        return carDto;
    }

    public static VanDto mapToVanDto(Van van, VanDto vanDto) {
        mapToVehicleDto(van, vanDto);
        vanDto.setCargoVolume(van.getCargoVolume());
        vanDto.setHasLiftGate(van.isHasLiftGate());
        return vanDto;
    }

    public static MotorCycleDto mapToMotorcycleDto(MotorCycle motorcycle, MotorCycleDto motorcycleDto) {
        mapToVehicleDto(motorcycle, motorcycleDto);
        motorcycleDto.setEngineSize(motorcycle.getEngineSize());
        motorcycleDto.setLicenseRequired(motorcycle.isLicenseRequired());
        return motorcycleDto;
    }

    // DTO to Entity
    public static Car mapToCar(CarDto carDto, Car car) {
        mapToVehicle(carDto, car);
        car.setNumDoors(carDto.getNumDoors());
        car.setFuelType(carDto.getFuelType());
        return car;
    }

    public static Van mapToVan(VanDto vanDto, Van van) {
        mapToVehicle(vanDto, van);
        van.setCargoVolume(vanDto.getCargoVolume());
        van.setHasLiftGate(vanDto.isHasLiftGate());
        return van;
    }

    public static MotorCycle mapToMotorcycle(MotorCycleDto motorcycleDto, MotorCycle motorcycle) {
        mapToVehicle(motorcycleDto, motorcycle);
        motorcycle.setEngineSize(motorcycleDto.getEngineSize());
        motorcycle.setLicenseRequired(motorcycleDto.isLicenseRequired());
        return motorcycle;
    }

    private static Vehicle mapToVehicle(VehicleDto vehicleDto, Vehicle vehicle) {
        vehicle.setId(vehicleDto.getId());
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setYear(vehicleDto.getYear());
        vehicle.setRentalPrice(vehicleDto.getRentalPrice());
        vehicle.setAvailable(vehicleDto.isAvailable());
        return vehicle;
    }
}
