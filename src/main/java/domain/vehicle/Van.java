package domain.vehicle;

public class Van extends Vehicle {

    private String cargoVolume;
    boolean hasLiftGate;
    public Van(Long id, String brand, String model, int year, double rentalPrice,boolean isAvailable, String cargoVolume,boolean hasLiftGate) {
        super(id, brand, model, year, rentalPrice,isAvailable);
        this.cargoVolume = cargoVolume;
        this.hasLiftGate = hasLiftGate;
    }



    public String getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(String cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public boolean isHasLiftGate() {
        return hasLiftGate;
    }

    public void setHasLiftGate(boolean hasLiftGate) {
        this.hasLiftGate = hasLiftGate;
    }
}
