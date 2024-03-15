package Concreate;

import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Abstract.ICustomerService;
import entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager  {

    ICustomerCheckService _customerCheckServis;

    public StarbucksCustomerManager(ICustomerCheckService _customerCheckServis) {
        this._customerCheckServis = _customerCheckServis;
    }

    @Override
    public void save(Customer customer) {

        try {
            if (_customerCheckServis.CheckIfRealPerson(customer)) {
                System.out.println("Müşteri kaydedildi.");
                super.save(customer);
            } else {
                throw new Exception("Not a valid person");

            }
        }
        catch (Exception e){
            System.err.println(e.getMessage()+" 1");
        }

    }


}
