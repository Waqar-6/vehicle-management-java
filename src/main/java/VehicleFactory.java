import classes.Car;
import classes.MotorCycle;
import classes.Van;
import classes.Vehicle;
import dto.CarDto;
import dto.MotorCycleDto;
import dto.VanDto;
import dto.VehicleDto;

public class VehicleFactory {

    public static <T extends VehicleDto> Vehicle createVehicle (String type, T data) {
        switch (type) {
            case "car" -> {
                if (data instanceof CarDto carDto)
                   return  new Car(carDto.getId(), carDto.getBrand(), carDto.getModel(), carDto.getYear(), carDto.getRentalPrice(), carDto.isAvailable(), carDto.getNumDoors(), carDto.getFuelType());
            }

            case "van" -> {
                if (data instanceof VanDto vanDto)
                    return new Van(vanDto.getId(), vanDto.getBrand(), vanDto.getModel(), vanDto.getYear(), vanDto.getRentalPrice(), vanDto.isAvailable(), vanDto.getCargoVolume(), vanDto.isAvailable());
            }

            case "motorcycle" -> {
                if (data instanceof MotorCycleDto motorCycleDto)
                    return new MotorCycle(motorCycleDto.getId(), motorCycleDto.getBrand(), motorCycleDto.getModel(), motorCycleDto.getYear(), motorCycleDto.getRentalPrice(), motorCycleDto.isAvailable(), motorCycleDto.getEngineSize(), motorCycleDto.isLicenseRequired());
            }

        }
        return null;

    }
}
