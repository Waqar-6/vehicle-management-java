package domain.user.controller;

import domain.user.entity.User;
import domain.user.requests.RegistrationRequest;
import domain.user.service.IUserService;
import domain.user.service.UserServiceImpl;
import dto.userdto.CustomerDto;
import dto.userdto.UserDto;

import java.util.List;

public class UserController {

    private final IUserService iUserService = new UserServiceImpl();

    public String registerUser (RegistrationRequest registrationRequest) {
        iUserService.createCustomer(registrationRequest);
        return "Hello "+ registrationRequest.getFirstName() + " Welcome :)";
    }

    public CustomerDto fetchUserById (Long id) {
        return iUserService.getCustomerById(id);
    }

    public List<CustomerDto> fetchAllCustomers () {
        return iUserService.getAllCustomers();
    }

    public String updateCustomer (Long id, CustomerDto customerDto) {
        iUserService.updateCustomer(id, customerDto);
        return "Successfully updated";
    }

    public String deleteCustomer (Long id) {
        iUserService.deleteCustomer(id);
        return "Good bye";
    }

}
