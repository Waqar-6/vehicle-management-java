import classes.Vehicle;
import dto.CarDto;
import dto.MotorCycleDto;
import dto.VanDto;
import exception.InvalidDataException;

public class Main {
    public static void main(String[] args) {

        try {
            CarDto carDto = new CarDto(1L, "BMW", "5 series", 2020, 120.00, true, 5,
                    "diesel");

            MotorCycleDto motorCycleDto = new MotorCycleDto(2L, "Harley", "2", 2000, 100.00, true, "500",
                    true);

            VanDto vanDto = new VanDto(3L, "Vauxhall", "Vivaro", 2024, 170.00, true, "1000",
                    true);
            Vehicle car = VehicleFactory.createVehicle("car", carDto);
            Vehicle motorCycle = VehicleFactory.createVehicle("motorcycle", motorCycleDto);
            Vehicle van = VehicleFactory.createVehicle("van", vanDto);
            Vehicle[] vehicleArr = {car,motorCycle,van};
            for (Vehicle vehicle : vehicleArr) System.out.println(vehicle.getVehicleInfo());
            String hirePriceForFiveDays = calc(vehicleArr, 5);
            System.out.println(hirePriceForFiveDays);
        }catch (InvalidDataException e) {
            System.out.println("error: " + e.getMessage());
        }







    }

    static String calc (Vehicle[] arr, int days) {
        for (Vehicle vehicle : arr)
            System.out.println(vehicle.getBrand() + " will cost: " + vehicle.calculateRentalCost(days) + " for " + days + "days");;
        return null;
    }
}
