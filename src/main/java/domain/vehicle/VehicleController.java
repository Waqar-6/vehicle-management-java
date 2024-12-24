package domain.vehicle;

import domain.vehicle.service.IVehicleService;
import domain.vehicle.service.VehicleServiceImpl;
import dto.vehicledto.VehicleDto;

import java.util.List;

public class VehicleController {

    private final IVehicleService iVehicleService = new VehicleServiceImpl();

    public void addVehicle(String type, VehicleDto data) {
        iVehicleService.createVehicle(type, data);
        System.out.println("Vehicle created successfully");
    }

    public void updateVehicle(Long id, VehicleDto data) {
        iVehicleService.updateVehicle(id, data);
        System.out.println("updated");
    }

    public void deleteVehicle(Long id) {
        iVehicleService.deleteVehicle(id);
    }
    public void displayAllVehicles() {
        List<VehicleDto> vehicles = iVehicleService.getAllVehicles();
        for (VehicleDto vehicleDto : vehicles) System.out.println(vehicleDto.toString());;
    }

    public void displayAvailableVehicles() {
        List<VehicleDto> vehicles = iVehicleService.getAvailableVehicles();
        for (VehicleDto vehicleDto : vehicles) displayVehicle(vehicleDto);
    }

    private void displayVehicle(VehicleDto vehicle) {
        System.out.println("ID: " + vehicle.getId());
        System.out.println("Brand: " + vehicle.getBrand());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("-----------------");
    }

}
