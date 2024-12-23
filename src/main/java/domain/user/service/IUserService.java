package domain.user.service;

import domain.user.entity.Customer;
import domain.user.requests.RegistrationRequest;
import dto.userdto.CustomerDto;

import java.util.List;

public interface IUserService {


    void createCustomer (RegistrationRequest registrationRequest);


    CustomerDto getCustomerById(Long id);
    CustomerDto getCustomerByEmail(String email);
    List<CustomerDto> getAllCustomers();

    void updateCustomer(Long id, CustomerDto customerDto);
    void deleteCustomer(Long id);
}
