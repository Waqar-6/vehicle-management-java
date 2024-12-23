package domain.user.service;

import db.DataStorage;
import domain.user.entity.Customer;
import domain.user.entity.User;
import domain.user.requests.RegistrationRequest;
import dto.userdto.CustomerDto;
import exception.AlreadyExistsException;
import exception.ResourceNotFoundException;
import mapper.UserMapper;

import java.util.List;


public class UserServiceImpl implements IUserService{

    private DataStorage dataStorage = new DataStorage();
    private List<User> userDb = dataStorage.getListOfUser();

    @Override
    public void createCustomer(RegistrationRequest registrationRequest) {
        String email = registrationRequest.getEmail();
        if (existsByEmail(email)) throw new AlreadyExistsException("user", "email", email);
        Customer newCustomer = UserMapper.mapRegistrationRequestToCustomer(registrationRequest, new Customer());
        userDb.add(newCustomer);
        dataStorage.setListOfUser(userDb);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = findById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer", "id", id.toString());
        }
        return UserMapper.mapToCustomerDto(customer, new CustomerDto());
    }

    @Override
    public CustomerDto getCustomerByEmail(String email) {
        Customer customer = findByEmail(email);
        if (customer == null) throw  new ResourceNotFoundException("Customer", "email",email);
        return UserMapper.mapToCustomerDto(customer, new CustomerDto());
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
         return userDb.stream()
                 .map(user -> UserMapper.mapToCustomerDto((Customer) user, new CustomerDto())).toList();
    }

    @Override
    public void updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = findById(id);
        if (customer == null) throw new ResourceNotFoundException("Customer", "id", id.toString());
        Customer updatedCustomer = UserMapper.mapToCustomer(customerDto, customer);
        dataStorage.setListOfUser(userDb);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = findById(id);
        if (customer == null) throw new ResourceNotFoundException("Customer", "id", id.toString());
        userDb.remove(customer);
        dataStorage.setListOfUser(userDb);
    }

    private boolean existsByEmail (String email) {
        for (User user : userDb) if (user.getEmail().equals(email)) return true;
        return false;
    }

    private Customer  findById (Long id) {
        for (User user : userDb) if (user.getId().equals(id)) return (Customer) user;
        return null;
    }

    private Customer findByEmail (String email) {
        for (User user : userDb)
            if (user.getEmail().equals(email)) return (Customer) user;
        return null;
    }

}
