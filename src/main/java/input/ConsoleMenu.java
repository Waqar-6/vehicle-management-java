package input;

import domain.user.controller.UserController;
import domain.user.requests.RegistrationRequest;
import dto.userdto.CustomerDto;

import java.util.List;

public class ConsoleMenu {

    private final UserController userController = new UserController();

    public void registerUser () {
       Long id =  InputHandler.readLong("Enter id");
       String firstName = InputHandler.readString("Enter first name");
       String lastName = InputHandler.readString("Enter last name");
       String email = InputHandler.readString("Enter email");
       String password = InputHandler.readString("Enter password");
       String address = InputHandler.readString("Enter address");
       String drivingLicence = InputHandler.readString("Enter driving licence number");
       RegistrationRequest registrationRequest = new RegistrationRequest(id, firstName, lastName, email, password, address, drivingLicence);
       String response = userController.registerUser(registrationRequest);
        System.out.println(response);
    }

    public void fetchCustomerById () {
        Long id = InputHandler.readLong("Enter id");
        CustomerDto customerDto = userController.fetchUserById(id);
        System.out.println(customerDto.toString());
    }

    public void fetchAllCustomers () {
        List<CustomerDto> customers = userController.fetchAllCustomers();
        customers.forEach(customer -> System.out.println(customer.toString()));
    }

    String[] menu = {"1. register", "2. fetchCustomer", "3. fetch all customers"};


    public void displayMenuOptions (String[] options) {
        for (String option : options) System.out.println(option);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenuOptions(menu);
            int choice = InputHandler.readInt("Enter your choice");

            try {
                switch (choice) {
                    case 1 -> registerUser();
                    case 2 -> fetchCustomerById();
                    case 3 -> fetchAllCustomers();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
