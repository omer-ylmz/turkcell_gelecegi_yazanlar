package Concreate;

import Abstract.ICustomerCheckService;
import Abstract.ICustomerService;
import entities.Customer;

public class CustomerCheckManager implements ICustomerCheckService {

    @Override
    public boolean CheckIfRealPerson(Customer customer) {
        return true;
    }
}
