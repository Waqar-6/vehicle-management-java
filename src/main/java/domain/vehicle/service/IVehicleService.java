package domain.vehicle.service;

import dto.vehicledto.VehicleDto;

import java.util.List;

public interface IVehicleService {

    <T extends VehicleDto> void createVehicle(String type, T data);
    List<VehicleDto> getAllVehicles();
    VehicleDto getVehicleById (Long id);
    List<VehicleDto> getAvailableVehicles();
    <T extends VehicleDto> void updateVehicle(Long id, T vehicleDto);
    void deleteVehicle(Long id);
    void updateVehicleAvailability(Long id, boolean isAvailable);
}
