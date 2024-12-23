package mapper;

import domain.user.entity.Customer;
import domain.user.requests.RegistrationRequest;
import dto.userdto.CustomerDto;

public final class UserMapper {

    private UserMapper () {}

    public static CustomerDto mapToCustomerDto (Customer customer, CustomerDto customerDto) {
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customerDto.getEmail());
        customerDto.setAddress(customer.getAddress());
        customerDto.setDrivingLicence(customer.getDrivingLicence());
        return customerDto;
    }

    public static Customer mapToCustomer ( CustomerDto customerDto, Customer customer) {
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        customer.setDrivingLicence(customerDto.getDrivingLicence());
        return customer;
    }

    public static Customer mapRegistrationRequestToCustomer (RegistrationRequest registrationRequest, Customer customer) {
        customer.setId(registrationRequest.getId());
        customer.setFirstName(registrationRequest.getFirstName());
        customer.setLastName(registrationRequest.getLastName());
        customer.setEmail(registrationRequest.getEmail());
        customer.setPassword(registrationRequest.getPassword());
        customer.setAddress(registrationRequest.getAddress());
        customer.setDrivingLicence(registrationRequest.getDrivingLicence());
        return customer;
    }
}
