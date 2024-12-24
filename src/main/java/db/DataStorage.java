package db;


import domain.rentalrecord.entity.RentalRecord;
import domain.user.entity.User;
import domain.vehicle.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    private List<User> listOfUser;
    private List<Vehicle> listOfVehicles;
    private List<RentalRecord> listOfRentalRecords;

    public DataStorage() {
        this.listOfUser = new ArrayList<>();
        this.listOfVehicles = new ArrayList<>();
        this.listOfRentalRecords = new ArrayList<>();
    }

    public List<User> getListOfUser() {
        return listOfUser;
    }

    public void setListOfUser(List<User> listOfUser) {
        this.listOfUser = listOfUser;
    }

    public List<Vehicle> getListOfVehicles() {
        return listOfVehicles;
    }

    public void setListOfVehicles(List<Vehicle> listOfVehicles) {
        this.listOfVehicles = listOfVehicles;
    }

    public List<RentalRecord> getListOfRentalRecords() {
        return listOfRentalRecords;
    }

    public void setListOfRentalRecords(List<RentalRecord> listOfRentalRecords) {
        this.listOfRentalRecords = listOfRentalRecords;
    }
}
