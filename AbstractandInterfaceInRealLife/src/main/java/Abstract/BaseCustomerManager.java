package Abstract;

import entities.Customer;

public abstract class BaseCustomerManager implements ICustomerService{

    public  void save(Customer customer) {
        System.out.println("Save to db : " + customer.getFirstName());
    }
}
